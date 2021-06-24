package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.web.exception.TechnicalException;

import java.util.List;

public interface AuteurService {

    List<AuteurBean> getAuteurs() throws TechnicalException;
    List<AuteurBean> getAuteurByNomContaining(String motCle) throws TechnicalException;
}
