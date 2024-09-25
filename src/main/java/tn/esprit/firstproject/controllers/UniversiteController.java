package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping("/getAll")
    public List<Universite> listAll(){
        return iUniversiteService.retrieveAllUniversites();
    }

    @GetMapping("/getUniversite/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable("idUniversite") Long chId) {
        return iUniversiteService.retrieveUniversite(chId);
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite c) {
        return iUniversiteService.addUniversite(c);
    }

    @DeleteMapping("/removeUniversite/{idUniversite}")
    public void removeUniversite(@PathVariable("idUniversite") Long chId) {
        iUniversiteService.removeUniversite(chId);
    }

    @PutMapping("/modifyUniversite")
    public Universite modifyUniversite(@RequestBody Universite c) {
        return iUniversiteService.modifyUniversite(c);
    }

}
