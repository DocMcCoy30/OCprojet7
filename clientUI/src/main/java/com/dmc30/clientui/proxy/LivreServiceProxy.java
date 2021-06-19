package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageBean;
import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.shared.bean.livre.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "livre-service", url = "localhost:9002")
public interface LivreServiceProxy {

    @GetMapping("/livres/all") //
    List<LivreBean> getLivres();

    @GetMapping("/livres/id") //
    ResponseEntity<?> getLivreById(@RequestParam("livreId") Long livreId);

    @PostMapping("/livres/titre") //
    List<LivreBean> getLivreByTitre(@RequestParam("motCle") String motCle);

    @GetMapping("/livres/auteur") //
    List<LivreBean> getLivreByAuteur(@RequestParam("auteurId") Long auteurId);

    @GetMapping("/livres/12") //
    List<LivreBean> get12LastLivres();

    @GetMapping("/auteurs/all")
    List<AuteurBean> getAuteurs();

    @GetMapping("auteurs/nom")
    List<AuteurBean> getAuteurByNomContaining(@RequestParam("motCle") String motCle);

    @GetMapping("/bibliotheques/all")
    ResponseEntity<?> getBibliotheques();

    @PostMapping("/bibliotheques/id")
    ResponseEntity<?> getBibliothequeById(@RequestParam("bibliothequeId") Long bibliothequeId);

    @GetMapping("/ouvrages/ouvrageDispoInOne")
    Integer getOuvrageDispoInOneBibliotheque(@RequestParam("livreId") Long livreId,
                                                    @RequestParam("bibliothequeId") Long bibliothequeId);

    @GetMapping("/ouvrages/ouvrageDispoInOther")
    List<Object> getOuvrageDispoInOtherBibliotheque(@RequestParam("livreId") Long livreId,
                                                            @RequestParam("bibliothequeId") Long bibliothequeId);

    @GetMapping("/ouvrages/idInterne")
    List<OuvrageBean> getOuvragesByIdInterne (@RequestParam("idInterne") String idInterne);

    @GetMapping("/ouvrages/ouvrage/idInterne")
    OuvrageBean getOuvrageByIdInterne (@RequestParam("idInterne") String idInterne);

    @GetMapping("/ouvrages/ouvrage/id")
    OuvrageBean getOuvrageById(@RequestParam("ouvrageId") Long ouvrageId);

    @GetMapping("ouvrages/livres")
    Long getLivreIdByOuvrageId(@RequestParam("ouvrageId") Long ouvrageId);
}
