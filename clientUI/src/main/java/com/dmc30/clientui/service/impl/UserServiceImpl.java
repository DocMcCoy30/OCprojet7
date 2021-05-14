package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.exception.TechnicalException;
import com.dmc30.clientui.proxy.UserServiceProxy;
import com.dmc30.clientui.security.TokenValidationHelper;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private TokenValidationHelper tokenValidationHelper;
    private UserServiceProxy userServiceProxy;

    @Autowired
    public UserServiceImpl(TokenValidationHelper tokenValidationHelper, UserServiceProxy userApiProxy, UserServiceProxy userServiceProxy) {
        this.tokenValidationHelper = tokenValidationHelper;
        this.userServiceProxy = userServiceProxy;
    }

    @Override
    public String check() {
        return userServiceProxy.check();
//        return userServiceProxy.check();
    }

//    @Override
//    public String login(LoginRequestDto loginRequestDto) {
//        return userServiceProxy.login(loginRequestDto);
//    }

//    @Override
//    public String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException {
//        ResponseEntity<String> responseEntity = userApiProxy.secureLogin(loginRequestDto);
//        logger.info(String.valueOf(responseEntity));
//        String[] returnValue = new String[0];
//        String publicId = "";
//        String token = "";
//        if (responseEntity.getHeaders().containsKey("publicId")) {
//            boolean auth = tokenValidationHelper.isJwtValid(responseEntity.getHeaders().get("token").get(0));
//            if (auth) {
//                returnValue = new String[]{"OK", responseEntity.getHeaders().get("publicId").get(0)};
//
//            } else {
//                returnValue = new String[]{"KO", "Token invalide ou expiré"};
//            }
//        } else if (responseEntity.getHeaders().containsKey("error")) {
//            returnValue = new String[]{"KO", responseEntity.getHeaders().get("error").get(0)};
//        }
//        return returnValue;
//    }

    @Override
    public String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException {
        ResponseEntity<String> responseEntity = userServiceProxy.secureLogin(loginRequestDto);
        String[] returnValue = new String[0];
        String publicId = "";

        if (responseEntity.getHeaders().containsKey("publicId")) {
            String roles = responseEntity.getHeaders().get("Roles").get(0);
            String token = responseEntity.getHeaders().get("Authorization").get(0);
//            UtilisateurDto user = userServiceProxy.findUtilisateurByPublicId(responseEntity.getHeaders().get("publicId").get(0));
            boolean auth = tokenValidationHelper.isJwtValid(responseEntity.getHeaders().get("Authorization").get(0));
            if (auth) {
                returnValue = new String[]{"OK", responseEntity.getHeaders().get("publicId").get(0)};
                SecurityContextHolder.getContext().setAuthentication(tokenValidationHelper.getAuthentication(token, roles));
                logger.info("SecurityContextHolder.getName " + SecurityContextHolder.getContext().getAuthentication().getName());
                logger.info("SecurityContextHolder.getPrincipal " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
                logger.info("SecurityContextHolder.getAuthorities " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());

            } else {
                returnValue = new String[]{"KO", "Token invalide ou expiré"};
            }
        } else if (responseEntity.getHeaders().containsKey("error")) {
            returnValue = new String[]{"KO", responseEntity.getHeaders().get("error").get(0)};
        }
        return returnValue;
    }

    @Override
    public ResponseEntity<CreateAbonneResponseModel> createAbonne(UtilisateurDto abonne, Long paysId) {
        return userServiceProxy.signin(abonne, paysId);
//        return userServiceProxy.signin(abonne, paysId);
    }

    @Override
    public UtilisateurDto getUtilisateurByPublicId(String publicId) {
        return userServiceProxy.findUtilisateurByPublicId(publicId);
    }

}

