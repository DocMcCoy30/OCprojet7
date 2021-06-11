package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.web.exception.TechnicalException;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.shared.bean.utilisateur.LoginRequestBean;

import java.util.List;

public interface UserService {

    String check();

//    String login(LoginRequestDto userAuthentication);

    String[] secureLogin(LoginRequestBean loginRequestBean) throws TechnicalException;

    UtilisateurBean createAbonne(UtilisateurBean abonne, Long paysId);

    UtilisateurBean getUtilisateurById(Long utilisateurId);

    UtilisateurBean getUtilisateurByPublicId(String publicId);

    UtilisateurBean getUtilisateurByUsername(String username);

    void updateAbonne(UtilisateurBean userDetails);

    UtilisateurBean getUtilisateurByNumAbonne(String numAbonne);

    List<UtilisateurBean> getUtilisateursByNumAbonne(String numAbonne);


}
