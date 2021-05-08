package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.springframework.http.ResponseEntity;

public interface ClientUIUserService {

    String check();

    String login(LoginRequestDto userAuthentication);

    ResponseEntity<CreateAbonneResponseModel> createAbonne(UsersDto abonne, Long paysId);

    void secureLogin(LoginRequestDto loginRequestDto);
}
