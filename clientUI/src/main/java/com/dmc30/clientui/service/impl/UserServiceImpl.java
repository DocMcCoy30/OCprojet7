package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.web.exception.TechnicalException;
import com.dmc30.clientui.proxy.UserServiceProxy;
import com.dmc30.clientui.security.TokenValidationHelper;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.service.dto.utilisateur.LoginRequestDto;
import com.dmc30.clientui.service.dto.utilisateur.UtilisateurDto;
import com.dmc30.clientui.web.model.CreateAbonneResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final TokenValidationHelper tokenValidationHelper;
    private final UserServiceProxy userServiceProxy;

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

    /**
     * Traitement des données de connexion (validation du token renvoyé par user-service)
     * @param loginRequestDto Les données de connexion de l'utilisateur
     * @return un message définissant le résultet du processus d'identification (succès ou échec)
     * @throws TechnicalException
     */
    @Override
    public String[] secureLogin(LoginRequestDto loginRequestDto) throws TechnicalException {
        ResponseEntity<String> responseEntity = userServiceProxy.secureLogin(loginRequestDto);
        String[] returnValue = new String[0];
        String publicId = "";

        if (responseEntity.getHeaders().containsKey("publicId")) {
            String roles = responseEntity.getHeaders().get("Roles").get(0);
            String token = responseEntity.getHeaders().get("Authorization").get(0);
            boolean auth = tokenValidationHelper.isJwtValid(responseEntity.getHeaders().get("Authorization").get(0));
            if (auth) {
                returnValue = new String[]{"OK", responseEntity.getHeaders().get("publicId").get(0)};
                SecurityContextHolder.getContext().setAuthentication(tokenValidationHelper.getAuthentication(token, roles));
            } else {
                returnValue = new String[]{"KO", "Token invalide ou expiré"};
            }
        } else if (responseEntity.getHeaders().containsKey("error")) {
            returnValue = new String[]{"KO", responseEntity.getHeaders().get("error").get(0)};
        }
        return returnValue;
    }

    /**
     * Crée un abonné dans la BD
     * @param abonne les détail de l'abonné, renseignés dans la vue
     * @param paysId l'identifiant du pays de résidence de l'abonné
     * @return
     */
    @Override
    public ResponseEntity<CreateAbonneResponseModel> createAbonne(UtilisateurDto abonne, Long paysId) {
        return userServiceProxy.signin(abonne, paysId);
    }

    /**
     * Cherche un utilisateur par son identifiant public
     * @param publicId l'identifiant public de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurDto getUtilisateurByPublicId(String publicId) {
        return userServiceProxy.findUtilisateurByPublicId(publicId);
    }

    /**
     * Cherche un utilisateur par son username
     * @param username l' username de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurDto getUtilisateurByUsername(String username) {
        return userServiceProxy.findUtilisateurByUsername(username);
    }

    /**
     * Met à jour le profil de l'utilisateur
     * @param userDetails les données de profil de l'utilisateur
     */
    @Override
    public void updateAbonne(UtilisateurDto userDetails) {

        userServiceProxy.updateUser(userDetails);
    }

    @Override
    public UtilisateurDto getUtilisateurByNumAbonné(String numAbonne) {
        return userServiceProxy.getUtilisateurByNumAbonne(numAbonne);
    }

    @Override
    public List<UtilisateurDto> getUtilisateursByNumAbonne(String numAbonne) {
        return userServiceProxy.getUtilisateursByNumAbonne(numAbonne);
    }

}

