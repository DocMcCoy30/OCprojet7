package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.security.TokenValidationHelper;
import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.proxy.UserApiProxy;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.service.contract.ClientUIUserService;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class ClientUIUserServiceImpl implements ClientUIUserService {

    Logger logger = LoggerFactory.getLogger(ClientUIUserServiceImpl.class);

    private TokenValidationHelper tokenValidationHelper;
    private UserApiProxy userApiProxy;

    @Autowired
    public ClientUIUserServiceImpl(TokenValidationHelper tokenValidationHelper, UserApiProxy userApiProxy) {
        this.tokenValidationHelper = tokenValidationHelper;
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
    public ResponseEntity<CreateAbonneResponseModel> createAbonne(UsersDto abonne, Long paysId) {
        return userApiProxy.signin(abonne, paysId);
    }

    @Override
    public ResponseEntity<String> secureLogin(LoginRequestDto loginRequestDto) {
        ResponseEntity<String> responseEntity = userApiProxy.secureLogin(loginRequestDto);
        logger.info(String.valueOf(responseEntity));
        String publicId = responseEntity.getHeaders().get("publicId").get(0);
        String token = responseEntity.getHeaders().get("token").get(0);
        logger.info("PublicId = " + publicId);
        logger.info("Token = " + token);
        boolean auth = tokenValidationHelper.isJwtValid(token);
        return responseEntity;
    }
}
