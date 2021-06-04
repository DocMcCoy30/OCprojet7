package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.web.exception.TechnicalException;
import com.dmc30.clientui.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.bean.utilisateur.LoginRequestBean;

import java.util.List;

public interface UserService {

    String check();

//    String login(LoginRequestDto userAuthentication);

    String[] secureLogin(LoginRequestBean loginRequestBean) throws TechnicalException;

    UtilisateurBean createAbonne(UtilisateurBean abonne, Long paysId);

    UtilisateurBean getUtilisateurByPublicId(String publicId);

    UtilisateurBean getUtilisateurByUsername(String username);

    void updateAbonne(UtilisateurBean userDetails);

    UtilisateurBean getUtilisateurByNumAbonné(String numAbonne);

    List<UtilisateurBean> getUtilisateursByNumAbonne(String numAbonne);

}
