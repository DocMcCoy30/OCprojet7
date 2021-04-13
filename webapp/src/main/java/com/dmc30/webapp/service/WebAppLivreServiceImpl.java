package com.dmc30.webapp.service;

import com.dmc30.webapp.model.bean.LivreBean;
import com.dmc30.webapp.proxy.LivreApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppLivreServiceImpl implements WebAppLivreService {

    LivreApiProxy livreApiProxy;

    @Autowired
    public WebAppLivreServiceImpl(LivreApiProxy livreApiProxy) {
        this.livreApiProxy = livreApiProxy;
    }

    @Override
    public List<LivreBean> getLivres() {
        return livreApiProxy.getLivres();
    }

    @Override
    public List<LivreBean> getLivreByTitre(String motCle) {
        return livreApiProxy.getLivreByTitre(motCle);
    }
}
