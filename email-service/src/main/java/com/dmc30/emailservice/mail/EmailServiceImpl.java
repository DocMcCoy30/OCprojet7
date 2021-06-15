package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.service.dto.CreateMailDto;
import com.dmc30.emailservice.service.dto.LivreForMailDto;
import com.dmc30.emailservice.service.dto.PretDto;
import com.dmc30.emailservice.service.dto.UtilisateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String NOREPLY_ADDRESS = "noreply@OCProjet7-Bibliothèque.com";

    JavaMailSender emailSender;


    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
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
    public CreateMailDto expiredPretEmailMaker(PretDto pret,
                                               UtilisateurDto utilisateur,
                                               List<LivreForMailDto> livres) {
        CreateMailDto createMailDto = new CreateMailDto();
        createMailDto.setUsername(utilisateur.getUsername());
        createMailDto.setPrenom(utilisateur.getPrenom());
        createMailDto.setNom(utilisateur.getNom());
        createMailDto.setEmail(utilisateur.getEmail());
        createMailDto.setLivres(livres);
        return createMailDto;
    }
}

