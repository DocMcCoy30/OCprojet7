package com.dmc30.userservice.service.contract;

import com.dmc30.userservice.shared.UtilisateurDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    UtilisateurDto createAbonne(UtilisateurDto utilisateurDto, Long paysId);

    UtilisateurDto getUserDetailsByEmail(String email);

    UtilisateurDto getUtilisateurByPublicId(String publicId);

    UtilisateurDto GetUtilisateurByUsername(String username);

    void updateUtilisateur(UtilisateurDto utilisateurDto);
}
