package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserAuthenticationBean;
import com.dmc30.clientui.proxy.UserApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientUIUserServiceImpl implements ClientUIUserService {

    UserApiProxy userApiProxy;

    @Autowired
    public ClientUIUserServiceImpl(UserApiProxy userApiProxy) {
        this.userApiProxy = userApiProxy;
    }

    @Override
    public String check() {
        return userApiProxy.check();
    }

    @Override
    public String login(UserAuthenticationBean userAuthentication) {
        return userApiProxy.login(userAuthentication);
    }

    @Override
    public void signin(AbonneBean abonne) {
        userApiProxy.signin(abonne);
    }
}
