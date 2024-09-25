package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/Foyer")
public class FoyerController {
    @Autowired
    IFoyerService iFoyerService;

    @GetMapping("/getAll")
    public List<Foyer> listAll(){
        return iFoyerService.retrieveAllFoyers();
    }

    @GetMapping("/getFoyer/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable("idFoyer") Long chId) {
        return iFoyerService.retrieveFoyer(chId);
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        return iFoyerService.addFoyer(c);
    }

    @DeleteMapping("/removeFoyer/{idFoyer}")
    public void removeFoyer(@PathVariable("idFoyer") Long chId) {
        iFoyerService.removeFoyer(chId);
    }

    @PutMapping("/modifyFoyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        return iFoyerService.modifyFoyer(c);
    }

    @PutMapping("/affecterfoyeruniverite/{idUniversite}/{idFoyer}")
    public Universite affecterfoyeruniverite(@PathVariable("idFoyer") Long fId, @PathVariable("idUniversite") Long uId){
        return iFoyerService.affecterFoyerAUniversite(fId,uId);
    }

    @PutMapping("/desaffecterfoyeruniverite/{idUniversite}")
    public Universite desaffecterfoyeruniverite(@PathVariable("idUniversite") Long uId){
        return iFoyerService.desaffecterFoyerAUniversite(uId);
    }

    @PutMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable("idUniversite") long uId) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer, uId);
    }
}
