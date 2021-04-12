package com.dmc30.webapp.service;

import com.dmc30.webapp.model.bean.LivreBean;

import java.util.List;

public interface WebAppLivreService {

    List<LivreBean> getLivres();
    List<LivreBean> getLivreByMotCle(String motCle);
}
