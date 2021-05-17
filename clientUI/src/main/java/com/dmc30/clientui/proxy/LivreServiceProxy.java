package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.livre.LivreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "livre-api", url = "localhost:9002")
public interface LivreServiceProxy {

    @GetMapping("/livres")
    List<LivreDto> getLivres();

    @PostMapping("/livres/titre")
    List<LivreDto> getLivreByTitre(@RequestParam("motCle") String motCle);

    @PostMapping("livres/auteur")
    List<LivreDto> getLivreByAuteur(@RequestParam("motCle") String motCle);
}
