package com.dmc30.clientui.service;

import com.dmc30.clientui.model.bean.livre.LivreBean;
import com.dmc30.clientui.proxy.LivreApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUILivreServiceImpl implements ClientUILivreService {

    LivreApiProxy livreApiProxy;

    @Autowired
    public ClientUILivreServiceImpl(LivreApiProxy livreApiProxy) {
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
