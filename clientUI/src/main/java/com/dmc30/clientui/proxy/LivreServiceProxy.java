package com.dmc30.clientui.proxy;

import com.dmc30.clientui.service.dto.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.service.dto.bibliotheque.OuvrageDto;
import com.dmc30.clientui.service.dto.livre.AuteurDto;
import com.dmc30.clientui.service.dto.livre.LivreDto;
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

    @GetMapping("/ouvrages")
    List<OuvrageDto> getOuvragesByIdInterne (@RequestParam("idInterne") String idInterne);

    @GetMapping("/ouvrage")
    OuvrageDto getOuvrageByIdInterne (@RequestParam("idInterne") String idInterne);

    @GetMapping("/ouvrage/id")
    OuvrageDto getOuvrageById(@RequestParam("ouvrageId") Long ouvrageId);

    @GetMapping("/livres/ouvrage")
    Long getLivreIdByOuvrageId(@RequestParam("ouvrageId") Long ouvrageId);
}
