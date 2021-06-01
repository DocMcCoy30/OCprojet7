package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserServiceProxy {

    @GetMapping("/users/check")
    String check();

    @GetMapping("/users/utilisateur")
    UtilisateurDto findUtilisateurByPublicId(@RequestParam String publicId);

    @GetMapping("/users/utilisateur/{username}")
    UtilisateurDto findUtilisateurByUsername(@RequestParam String username);
//
//    @GetMapping("/employe")
//    UtilisateurDto findEmployeByPublicId(String publicId);

    @PostMapping("/users/login")
    String login(@RequestBody LoginRequestDto user);

    @PostMapping("/secure/login")
    ResponseEntity<String> secureLogin(LoginRequestDto loginRequestDto);

    @PostMapping("/users/signin")
    ResponseEntity<CreateAbonneResponseModel> signin(@RequestBody UtilisateurDto abonne, @RequestParam Long paysId);

    @PostMapping("users/update")
    void updateUser(@RequestBody UtilisateurDto userDetails);
}
