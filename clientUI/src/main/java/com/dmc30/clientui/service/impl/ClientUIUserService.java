package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.model.dto.utilisateur.AbonneDto;
import com.dmc30.clientui.model.dto.utilisateur.UserDetailsDto;

public interface ClientUIUserService {

    String check();

    String login(UserDetailsDto userAuthentication);

    String signin(AbonneDto abonne, int paysId);
}
