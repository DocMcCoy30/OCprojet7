package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserServiceProxy {

    @GetMapping("/users/check")
    String check();

    @GetMapping("/users/utilisateur")
    UtilisateurDto findUtilisateurByPublicId(@RequestParam String publicId);

    @GetMapping("/users/utilisateur/{username}")
    UtilisateurDto findUtilisateurByUsername(@RequestParam String username);

    @PostMapping("/users/login")
    String login(@RequestBody LoginRequestDto user);

    @PostMapping("/secure/login")
    ResponseEntity<String> secureLogin(LoginRequestDto loginRequestDto);

    @PostMapping("/users/signin")
    ResponseEntity<CreateAbonneResponseModel> signin(@RequestBody UtilisateurDto abonne, @RequestParam Long paysId);

    @PostMapping("users/update")
    void updateUser(@RequestBody UtilisateurDto userDetails);


    @GetMapping("users/utilisateur/numAb")
    UtilisateurDto getUtilisateurByNumAbonne(@RequestParam String numAbonne);

    @PostMapping("users/utilisateurs")
    List<UtilisateurDto> getUtilisateursByNumAbonne(@RequestParam String numAbonne);

}
