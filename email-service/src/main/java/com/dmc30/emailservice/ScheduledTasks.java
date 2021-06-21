package com.dmc30.emailservice;

import com.dmc30.emailservice.mail.EmailService;
import com.dmc30.emailservice.service.contract.EmpruntService;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import com.dmc30.emailservice.service.bean.CreateMailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

@Component
public class ScheduledTasks {

    EmpruntService empruntService;
    UtilisateurService utilisateurService;
    EmailService emailService;

    @Autowired
    public ScheduledTasks(EmpruntService empruntService,
                          UtilisateurService utilisateurService,
                          EmailService emailService) {
        this.empruntService = empruntService;
        this.utilisateurService = utilisateurService;
        this.emailService = emailService;
    }

//    @Scheduled(cron = "0 0 0 * * ?") // tous les jours à minuit
//    @Scheduled(cron = "*/30 * * * * *") // toutes les 30 secondes
    @Scheduled(cron = "*/10 * * * * *") // toutes les 10 secondes
    public void scheduledTaskServiceTest() throws MessagingException {
        System.out.println("scheduledTaskTest is running.");
        Locale locale = new Locale("FRANCE");
        List<CreateMailBean> mailToSendList = emailService.createMailList();
        for (CreateMailBean mailToSend : mailToSendList) {
            emailService.sendSimpleMail(mailToSend, locale);
        }
    }

}
