package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.PretBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "emprunt-service", url = "localhost:9003")
public interface EmpruntServiceProxy {

    @PostMapping("/emprunts/create")
    PretBean createEmprunt(@RequestBody CreateEmpruntBean createEmpruntBean);

    @GetMapping("/emprunts/encours")
    List<PretBean> findEmpruntEnCours(@RequestParam Long bibliothequeId);

    @GetMapping("/emprunts/utilisateur")
    List<PretBean> findEmpruntByUtilisateurId(@RequestParam Long utilisateurId);

    @GetMapping("/emprunts/retour")
    void retournerEmprunt(@RequestParam Long empruntId, @RequestParam String ouvrageId);

    @GetMapping("/emprunts/prolongation")
    void prolongerEmprunt(@RequestParam Long empruntId);
}
