package com.dmc30.emailservice.service.contract;

import com.dmc30.emailservice.service.dto.LivreForMailDto;

public interface LivreService {

    LivreForMailDto getTitreDuLivre(Long ouvrageId);

}
