package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;

import java.util.List;

public interface BibliothequeService {

    List<BibliothequeBean> getBibliotheques();
    BibliothequeBean getBibliothequeById(Long bibliothequeId);
}
