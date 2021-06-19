package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BibliothequeService {

    ResponseEntity<?> getBibliotheques();
    ResponseEntity<?> getBibliothequeById(Long bibliothequeId);
}
