package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.service.bean.CreateMailBean;
import com.dmc30.emailservice.service.bean.LivreForMailBean;
import com.dmc30.emailservice.service.bean.PretBean;
import com.dmc30.emailservice.service.bean.UtilisateurBean;
import com.dmc30.emailservice.service.contract.EmpruntService;
import com.dmc30.emailservice.service.contract.LivreService;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_SIMPLE_TEMPLATE_NAME = "email-simple";
    private static final String NOREPLY_ADDRESS = "noreply@OCProjet7-Bibliothèque.com";
    private static final String SUBJECT = "Non restitution de votre (vos) emprunt(s)";

    private EmpruntService empruntService;
    private LivreService livreService;
    private UtilisateurService utilisateurService;
    private JavaMailSender emailSender;
    TemplateEngine htmlTemplateEngine;

    @Autowired
    public EmailServiceImpl(EmpruntService empruntService,
                            LivreService livreService,
                            UtilisateurService utilisateurService,
                            JavaMailSender emailSender,
                            TemplateEngine htmlTemplateEngine) {
        this.empruntService = empruntService;
        this.livreService = livreService;
        this.utilisateurService = utilisateurService;
        this.emailSender = emailSender;
        this.htmlTemplateEngine = htmlTemplateEngine;
    }

    /*
     * Send HTML mail (simple)
     */
    public void sendSimpleMail(
            CreateMailBean createMailBean, final Locale locale)
            throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", createMailBean.getUsername());
        ctx.setVariable("livres", createMailBean.getLivres());
        ctx.setVariable("subscriptionDate", new Date());

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(SUBJECT);
        message.setFrom(NOREPLY_ADDRESS);
        message.setTo(createMailBean.getEmail());

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Send email
        this.emailSender.send(mimeMessage);
    }

    @Override
    public List<CreateMailBean> createMailList() {
        List<CreateMailBean> mailToCreateList = new ArrayList<>();
        List<LivreForMailBean> livres = new ArrayList<>();
        List<PretBean> expiredPretsList = new ArrayList<>();
        List<Long> utilisateursEnRetardId = empruntService.findUtilisateurEnRetard();
        for (Long utisateurEnRetardId : utilisateursEnRetardId) {
            UtilisateurBean utilisateurBean = utilisateurService.findUtilisateurById(utisateurEnRetardId);
            expiredPretsList = empruntService.findExpiredPretsByUtilisateurId(utisateurEnRetardId);
            for (int i = 0; i < expiredPretsList.size(); i++) {
                LivreForMailBean livre = livreService.getTitreDuLivre(expiredPretsList.get(i).getOuvrageId());
                livres.add(livre);
            }
            CreateMailBean newMail = expiredPretEmailMaker(utilisateurBean, livres);
            mailToCreateList.add(newMail);
            livres = new ArrayList<>();
        }
        return mailToCreateList;
    }


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public CreateMailBean expiredPretEmailMaker(
                                               UtilisateurBean utilisateur,
                                               List<LivreForMailBean> livres) {
        CreateMailBean createMailBean = new CreateMailBean();
        createMailBean.setUserId(utilisateur.getId());
        createMailBean.setUsername(utilisateur.getUsername());
        createMailBean.setPrenom(utilisateur.getPrenom());
        createMailBean.setNom(utilisateur.getNom());
        createMailBean.setEmail(utilisateur.getEmail());
        createMailBean.setLivres(livres);
        return createMailBean;
    }
}

