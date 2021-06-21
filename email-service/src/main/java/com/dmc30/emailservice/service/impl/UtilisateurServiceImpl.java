package com.dmc30.emailservice.service.impl;

import com.dmc30.emailservice.proxy.UserServiceProxy;
import com.dmc30.emailservice.service.bean.UtilisateurBean;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    UserServiceProxy userServiceProxy;

    @Autowired
    public UtilisateurServiceImpl(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    @Override
    public List<UtilisateurBean> findAll() {
        List<UtilisateurBean> utilisateurs = userServiceProxy.findAll();
        return utilisateurs;
    }

    @Override
    public UtilisateurBean findUtilisateurById(Long utilisateurId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurBean utilisateurBean = userServiceProxy.findUtilisateurById(utilisateurId);
        return utilisateurBean;
    }
}
