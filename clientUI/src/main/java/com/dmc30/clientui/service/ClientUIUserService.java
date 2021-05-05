package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserDetails;

public interface ClientUIUserService {

    String check();

    String login(UserDetails userAuthentication);

    String signin(AbonneBean abonne, int paysId);
}
