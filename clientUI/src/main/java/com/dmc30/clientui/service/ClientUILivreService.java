package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.livre.LivreBean;

import java.util.List;

public interface ClientUILivreService {

    List<LivreBean> getLivres();
    List<LivreBean> getLivreByTitre(String motCle);
}
