package com.dmc30.emailservice.mail;

import com.dmc30.emailservice.service.dto.CreateMailDto;
import com.dmc30.emailservice.service.dto.LivreForMailDto;
import com.dmc30.emailservice.service.dto.PretDto;
import com.dmc30.emailservice.service.dto.UtilisateurDto;

import java.util.List;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    CreateMailDto expiredPretEmailMaker(PretDto pret,
                                        UtilisateurDto utilisateur,
                                        List<LivreForMailDto> livres);
}
