package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserApiProxy {

    @GetMapping("/users/check")
    String check();

    @PostMapping("/users/login")
    String login(@RequestBody LoginRequestDto user);

    @PostMapping("/users/signin")
    String signin(@RequestBody UsersDto abonne, @RequestParam Long paysId);

    @PostMapping("/secure/login")
    void secureLogin(LoginRequestDto loginRequestDto);
}
