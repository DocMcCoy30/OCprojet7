package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserApiProxy {

    @GetMapping("/users/check")
    String check();

    @PostMapping("/users/login")
    String login(@RequestBody LoginRequestDto user);

    @PostMapping("/users/signin")
    ResponseEntity<CreateAbonneResponseModel> signin(@RequestBody UsersDto abonne, @RequestParam Long paysId);



    @PostMapping("/secure/login")
    ResponseEntity<String> secureLogin(LoginRequestDto loginRequestDto);
}
