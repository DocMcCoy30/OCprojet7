package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.web.exception.TechnicalException;
import com.dmc30.clientui.proxy.UserServiceProxy;
import com.dmc30.clientui.security.TokenValidationHelper;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.bean.utilisateur.LoginRequestBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
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
     * @param loginRequestBean Les données de connexion de l'utilisateur
     * @return un message définissant le résultet du processus d'identification (succès ou échec)
     * @throws TechnicalException
     */
    @Override
    public String[] secureLogin(LoginRequestBean loginRequestBean) throws TechnicalException {
        ResponseEntity<String> responseEntity = userServiceProxy.secureLogin(loginRequestBean);
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
    public UtilisateurBean createAbonne(UtilisateurBean abonne, Long paysId) {
        return userServiceProxy.signin(abonne, paysId);
    }

    /**
     * Cherche un utilisateur par son identifiant
     * @param utilisateurId l'identifiant de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurBean getUtilisateurById(Long utilisateurId) {
        return userServiceProxy.findUtilisateurById(utilisateurId);
    }

    /**
     * Cherche un utilisateur par son identifiant public
     * @param publicId l'identifiant public de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurBean getUtilisateurByPublicId(String publicId) {
        return userServiceProxy.findUtilisateurByPublicId(publicId);
    }

    /**
     * Cherche un utilisateur par son username
     * @param username l' username de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurBean getUtilisateurByUsername(String username) {
        return userServiceProxy.findUtilisateurByUsername(username);
    }

    /**
     * Met à jour le profil de l'utilisateur
     * @param userDetails les données de profil de l'utilisateur
     */
    @Override
    public void updateAbonne(UtilisateurBean userDetails) {

        userServiceProxy.updateUser(userDetails);
    }

    @Override
    public UtilisateurBean getUtilisateurByNumAbonne(String numAbonne) {
        return userServiceProxy.getUtilisateurByNumAbonne(numAbonne);
    }

    @Override
    public List<UtilisateurBean> getUtilisateursByNumAbonne(String numAbonne) {
        return userServiceProxy.getUtilisateursByNumAbonne(numAbonne);
    }

}

