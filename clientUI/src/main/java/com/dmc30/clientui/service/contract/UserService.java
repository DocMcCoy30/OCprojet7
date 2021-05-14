package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.exception.TechnicalException;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.springframework.http.ResponseEntity;

public interface UserService {

    String check();

//    String login(LoginRequestDto userAuthentication);

    String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException;

    ResponseEntity<CreateAbonneResponseModel> createAbonne(UtilisateurDto abonne, Long paysId);

    UtilisateurDto getUtilisateurByPublicId(String publicId);

}
