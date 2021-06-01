package com.dmc30.clientui.proxy;

import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.livre.AuteurDto;
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

    @GetMapping("/livres/12")
    List<LivreDto> get12LastLivres();

    @PostMapping("/livres/titre")
    List<LivreDto> getLivreByTitre(@RequestParam("motCle") String motCle);

    @GetMapping("livres/auteur")
    List<LivreDto> getLivreByAuteur(@RequestParam("auteurId") Long auteurId);

    @PostMapping("auteurs")
    List<AuteurDto> getAuteurByNomContaining(@RequestParam("motCle") String motCle);

    @GetMapping("/bibliotheques")
    List<BibliothequeDto> getBibliotheques();

    @GetMapping("livres/id")
    LivreDto getLivreById(@RequestParam("livreId") Long livreId);

    @PostMapping("/bibliotheque")
    BibliothequeDto getBibliotheque(@RequestParam("bibliothequeId") Long bibliothequeId);

    @GetMapping("/ouvrageDispoInOne")
    Integer getOuvrageDispoInOneBibliotheque(@RequestParam("livreId") Long livreId,
                                                    @RequestParam("bibliothequeId") Long bibliothequeId);

    @GetMapping("/ouvrageDispoInOther")
    List<Object> getOuvrageDispoInOtherBibliotheque(@RequestParam("livreId") Long livreId,
                                                            @RequestParam("bibliothequeId") Long bibliothequeId);

}
