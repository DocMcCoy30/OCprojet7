package com.dmc30.clientui.proxy;

import com.dmc30.clientui.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.bean.bibliotheque.OuvrageBean;
import com.dmc30.clientui.bean.livre.AuteurBean;
import com.dmc30.clientui.bean.livre.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "livre-api", url = "localhost:9002")
public interface LivreServiceProxy {

    @GetMapping("/livres/all") //
    List<LivreBean> getLivres();

    @GetMapping("/livres/id") //
    LivreBean getLivreById(@RequestParam("livreId") Long livreId);

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
    List<BibliothequeBean> getBibliotheques();

    @PostMapping("/bibliotheques/id")
    BibliothequeBean getBibliothequeById(@RequestParam("bibliothequeId") Long bibliothequeId);

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
