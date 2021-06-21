package com.dmc30.emailservice.proxy;

import com.dmc30.emailservice.service.bean.UtilisateurBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service", url = "localhost:9001")
public interface UserServiceProxy {

    @GetMapping("/users/all")
    List<UtilisateurBean> findAll();

    @GetMapping("/users/id")
    UtilisateurBean findUtilisateurById(@RequestParam Long utilisateurId);

}
