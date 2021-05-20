package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;

import java.util.List;

public interface BibliothequeService {

    List<BibliothequeDto> getBibliotheques();

    BibliothequeDto getBibliotheque(Long bibliothequeId);
}
