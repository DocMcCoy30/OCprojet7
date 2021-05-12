package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserServiceProxy {

    @GetMapping("/users/check")
    String check();

    @GetMapping("/users/abonne")
    UtilisateurDto findAbonneByPublicId(@RequestParam String publicId);

    @GetMapping("/employe")
    UtilisateurDto findEmployeByPublicId(String publicId);

    @PostMapping("/users/login")
    String login(@RequestBody LoginRequestDto user);

    @PostMapping("/secure/login")
    ResponseEntity<String> secureLogin(LoginRequestDto loginRequestDto);

    @PostMapping("/users/signin")
    ResponseEntity<CreateAbonneResponseModel> signin(@RequestBody UtilisateurDto abonne, @RequestParam Long paysId);


}
