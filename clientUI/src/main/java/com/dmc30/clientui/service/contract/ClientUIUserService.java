package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.LoginRequestModel;

public interface ClientUIUserService {

    String check();

    String login(LoginRequestDto userAuthentication);

    String createAbonne(UsersDto abonne, Long paysId);

    void secureLogin(LoginRequestDto loginRequestDto);
}
