package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.service.bean.CreateMailBean;
import com.dmc30.emailservice.service.bean.LivreForMailBean;
import com.dmc30.emailservice.service.bean.UtilisateurBean;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMail(
            CreateMailBean createMailBean, final Locale locale)
            throws MessagingException;

    List<CreateMailBean> createMailList();

    CreateMailBean expiredPretEmailMaker(
            UtilisateurBean utilisateur,
            List<LivreForMailBean> livres);
}
