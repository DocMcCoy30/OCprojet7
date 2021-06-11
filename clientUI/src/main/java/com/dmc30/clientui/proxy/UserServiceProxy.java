package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.shared.bean.utilisateur.LoginRequestBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "localhost:9001")
public interface UserServiceProxy {

    @GetMapping("/users/check")
    String check();

    @GetMapping("/users/id")
    UtilisateurBean findUtilisateurById(@RequestParam Long utilisateurId);

    @GetMapping("/users/publicId")
    UtilisateurBean findUtilisateurByPublicId(@RequestParam String publicId);

    @GetMapping("/users/username")
    UtilisateurBean findUtilisateurByUsername(@RequestParam String username);

    @GetMapping("users/numAb")
    UtilisateurBean getUtilisateurByNumAbonne(@RequestParam String numAbonne);

    @GetMapping("users/utilisateurs")
    List<UtilisateurBean> getUtilisateursByNumAbonne(@RequestParam String numAbonne);

    @PostMapping("/users/signin")
    UtilisateurBean signin(@RequestBody UtilisateurBean abonne, @RequestParam Long paysId);

    @PostMapping("users/update")
    void updateUser(@RequestBody UtilisateurBean userDetails);

    @PostMapping("/secure/login")
    ResponseEntity<String> secureLogin(LoginRequestBean loginRequestBean);
}
