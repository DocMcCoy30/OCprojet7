package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.proxy.UserApiProxy;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.service.contract.ClientUIUserService;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.springframework.stereotype.Service;

@Service
public class ClientUIUserServiceImpl implements ClientUIUserService {

    UserApiProxy userApiProxy;


    public ClientUIUserServiceImpl(UserApiProxy userApiProxy, PasswordEncoderHelper encoderHelper) {
        this.userApiProxy = userApiProxy;
    }

    @Override
    public String check() {
        return userApiProxy.check();
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        return userApiProxy.login(loginRequestDto);
    }

    @Override
    public String createAbonne(UsersDto abonne, Long paysId) {
//        abonne.setEncryptedPassword(encoderHelper.passwordEncoder(abonne.getPassword()));
        return userApiProxy.signin(abonne, paysId);
    }

    @Override
    public void secureLogin(LoginRequestDto loginRequestDto) {
        userApiProxy.secureLogin(loginRequestDto);
    }
}
