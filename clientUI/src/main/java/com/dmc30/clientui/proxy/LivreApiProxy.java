package com.dmc30.clientui.proxy;

import com.dmc30.clientui.model.bean.livre.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "livre-api", url = "localhost:9001")
public interface LivreApiProxy {

    @GetMapping("/livres")
    List<LivreBean> getLivres();

    @PostMapping("/livres/titre")
    List<LivreBean> getLivreByTitre(@RequestParam("motCle") String motCle);
}
