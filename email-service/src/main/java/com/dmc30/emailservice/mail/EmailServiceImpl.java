package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.data.entity.LivreEntity;
import com.dmc30.emailservice.service.contract.EmpruntService;
import com.dmc30.emailservice.service.contract.LivreService;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import com.dmc30.emailservice.service.dto.CreateMailDto;
import com.dmc30.emailservice.service.dto.LivreForMailDto;
import com.dmc30.emailservice.service.dto.PretDto;
import com.dmc30.emailservice.service.dto.UtilisateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

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
            CreateMailDto createMailDto, final Locale locale)
            throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", createMailDto.getUsername());
        ctx.setVariable("livres", createMailDto.getLivres());
        ctx.setVariable("subscriptionDate", new Date());

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(SUBJECT);
        message.setFrom(NOREPLY_ADDRESS);
        message.setTo(createMailDto.getEmail());

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Send email
        this.emailSender.send(mimeMessage);
    }

    @Override
    public List<CreateMailDto> createMailList() {
        List<CreateMailDto> mailToCreateList = new ArrayList<>();
        List<LivreForMailDto> livres = new ArrayList<>();
        List<PretDto> expiredPretsList = new ArrayList<>();
        List<Long> utilisateursEnRetardId = empruntService.findUtilisateurEnRetard();
        for (Long utisateurEnRetardId : utilisateursEnRetardId) {
            UtilisateurDto utilisateurDto = utilisateurService.findById(utisateurEnRetardId);
            expiredPretsList = empruntService.findExpiredPretsByUtilisateurId(utisateurEnRetardId);
            for (int i = 0; i < expiredPretsList.size(); i++) {
                LivreForMailDto livre = livreService.getTitreDuLivre(expiredPretsList.get(i).getOuvrageId());
                livres.add(livre);
            }
            CreateMailDto newMail = expiredPretEmailMaker(utilisateurDto, livres);
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
    public CreateMailDto expiredPretEmailMaker(
                                               UtilisateurDto utilisateur,
                                               List<LivreForMailDto> livres) {
        CreateMailDto createMailDto = new CreateMailDto();
        createMailDto.setUserId(utilisateur.getId());
        createMailDto.setUsername(utilisateur.getUsername());
        createMailDto.setPrenom(utilisateur.getPrenom());
        createMailDto.setNom(utilisateur.getNom());
        createMailDto.setEmail(utilisateur.getEmail());
        createMailDto.setLivres(livres);
        return createMailDto;
    }
}

