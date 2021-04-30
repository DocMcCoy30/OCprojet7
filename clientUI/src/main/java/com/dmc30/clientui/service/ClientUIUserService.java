package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserAuthenticationBean;

public interface ClientUIUserService {

    String check();

    String login(UserAuthenticationBean userAuthentication);

    void signin(AbonneBean abonne);
}
