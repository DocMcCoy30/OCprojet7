package com.dmc30.clientui.proxy;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserAuthenticationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserApiProxy {

    @GetMapping("/users/check")
    String check();

    @GetMapping("/login")
    String pageLogin ();

    @PostMapping("/login")
    void login(@RequestBody UserAuthenticationBean user);

    @GetMapping("/signin")
    String pageSignin ();

    @PostMapping("/signin")
    void signin(@RequestBody AbonneBean abonne);
}
