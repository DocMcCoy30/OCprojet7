package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserDetails;
import com.dmc30.clientui.proxy.UserApiProxy;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import org.springframework.stereotype.Service;

@Service
public class ClientUIUserServiceImpl implements ClientUIUserService {

    UserApiProxy userApiProxy;
    PasswordEncoderHelper encoderHelper;

    public ClientUIUserServiceImpl(UserApiProxy userApiProxy, PasswordEncoderHelper encoderHelper) {
        this.userApiProxy = userApiProxy;
        this.encoderHelper = encoderHelper;
    }

    @Override
    public String check() {
        return userApiProxy.check();
    }

    @Override
    public String login(UserDetails userAuthentication) {
        return userApiProxy.login(userAuthentication);
    }

    @Override
    public String signin(AbonneBean abonne, int paysId) {
        abonne.setPassword(encoderHelper.passwordEncoder(abonne.getPassword()));
        return userApiProxy.signin(abonne, paysId);
    }
}
