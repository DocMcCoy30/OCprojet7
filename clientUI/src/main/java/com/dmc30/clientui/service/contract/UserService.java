package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.web.exception.TechnicalException;
import com.dmc30.clientui.service.dto.utilisateur.UtilisateurDto;
import com.dmc30.clientui.service.dto.utilisateur.LoginRequestDto;
import com.dmc30.clientui.web.model.CreateAbonneResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    String check();

//    String login(LoginRequestDto userAuthentication);

    String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException;

    ResponseEntity<CreateAbonneResponseModel> createAbonne(UtilisateurDto abonne, Long paysId);

    UtilisateurDto getUtilisateurByPublicId(String publicId);

    UtilisateurDto getUtilisateurByUsername(String username);

    void updateAbonne(UtilisateurDto userDetails);

    UtilisateurDto getUtilisateurByNumAbonné(String numAbonne);

    List<UtilisateurDto> getUtilisateursByNumAbonne(String numAbonne);

}
