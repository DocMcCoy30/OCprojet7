package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.bean.bibliotheque.PretBean;

public interface EmpruntService {
    PretBean createEmprunt(CreateEmpruntBean createEmpruntBean);
}
