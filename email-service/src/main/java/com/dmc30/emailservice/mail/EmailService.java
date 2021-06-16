package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.service.dto.CreateMailDto;
import com.dmc30.emailservice.service.dto.LivreForMailDto;
import com.dmc30.emailservice.service.dto.PretDto;
import com.dmc30.emailservice.service.dto.UtilisateurDto;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMail(
            CreateMailDto createMailDto, final Locale locale)
            throws MessagingException;

    List<CreateMailDto> createMailList();

    CreateMailDto expiredPretEmailMaker(
            UtilisateurDto utilisateur,
            List<LivreForMailDto> livres);
}
