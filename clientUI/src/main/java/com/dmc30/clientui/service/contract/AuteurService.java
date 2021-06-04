package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.bean.livre.AuteurBean;

import java.util.List;

public interface AuteurService {

    List<AuteurBean> getAuteurs();
    List<AuteurBean> getAuteurByNomContaining(String motCle);
}
