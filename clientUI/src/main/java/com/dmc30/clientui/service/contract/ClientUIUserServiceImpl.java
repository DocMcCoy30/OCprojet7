package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.model.dto.utilisateur.AbonneDto;
import com.dmc30.clientui.model.dto.utilisateur.UserDetailsDto;
import com.dmc30.clientui.proxy.UserApiProxy;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.service.impl.ClientUIUserService;
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
    public String login(UserDetailsDto userDetailsDto) {
        return userApiProxy.login(userDetailsDto);
    }

    @Override
    public String signin(AbonneDto abonneDto, int paysId) {
        abonneDto.setPassword(encoderHelper.passwordEncoder(abonneDto.getPassword()));
        return userApiProxy.signin(abonneDto, paysId);
    }
}
