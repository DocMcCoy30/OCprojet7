package com.dmc30.emailservice;

import com.dmc30.emailservice.data.entity.LivreEntity;
import com.dmc30.emailservice.mail.EmailService;
import com.dmc30.emailservice.service.contract.EmpruntService;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import com.dmc30.emailservice.service.dto.CreateMailDto;
import com.dmc30.emailservice.service.dto.PretDto;
import com.dmc30.emailservice.service.dto.UtilisateurDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Scheduled(fixedRate = 40000)
    public void scheduledTaskServiceTest() {
        System.out.println("scheduledTaskTest is running.");
        List<CreateMailDto> mailToCreateList = new ArrayList<>();
        List<PretDto> expiredPretsList = empruntService.findExpiredPrets();
        for (PretDto expiredPretDto:expiredPretsList) {
            if(mailToCreateList.isEmpty()) {

            }

        }
        List<UtilisateurDto> utilisateurDtoList = utilisateurService.findAll();
        for (UtilisateurDto utilisateur:utilisateurDtoList) {
            String email = utilisateur.getEmail();
            emailService.sendSimpleMessage(email, "Test2 avec springScheduller", "Ceci est le test 2");
        }
    }
}
