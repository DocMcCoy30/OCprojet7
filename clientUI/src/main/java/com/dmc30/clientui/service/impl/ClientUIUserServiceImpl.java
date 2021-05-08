package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.exception.ErrorMessage;
import com.dmc30.clientui.exception.TechnicalException;
import com.dmc30.clientui.proxy.UserApiProxy;
import com.dmc30.clientui.security.TokenValidationHelper;
import com.dmc30.clientui.service.contract.ClientUIUserService;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException {
        ResponseEntity<String> responseEntity = userApiProxy.secureLogin(loginRequestDto);
        logger.info(String.valueOf(responseEntity));
        String[] returnValue = new String[0];
        String publicId = "";
        String token = "";
        if(responseEntity.getHeaders().containsKey("publicId")) {
            boolean auth = tokenValidationHelper.isJwtValid(responseEntity.getHeaders().get("token").get(0));
            if (auth) {
                returnValue = new String[]{"OK", responseEntity.getHeaders().get("publicId").get(0)};
            } else {
                returnValue = new String[]{"KO", "Token invalide ou expiré"};
            }
        } else if (responseEntity.getHeaders().containsKey("error")) {
            returnValue = new String[]{"KO", responseEntity.getHeaders().get("error").get(0)};
        }
        return returnValue;
    }

    @Override
    public UsersDto getAbonneByPublicId(String publicId) {
        return userApiProxy.findAbonneByPublicId(publicId);
    }
}

