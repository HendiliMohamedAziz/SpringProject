package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService iEtudiantService;

    @GetMapping("/getAll")
    public List<Etudiant> listAll(){
        return iEtudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/getEtudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable("idEtudiant") Long chId) {
        return iEtudiantService.retrieveEtudiant(chId);
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant c) {
        return iEtudiantService.addEtudiant(c);
    }

    @DeleteMapping("/removeEtudiant/{idEtudiant}")
    public void removeEtudiant(@PathVariable("idEtudiant") Long chId) {
        iEtudiantService.removeEtudiant(chId);
    }

    @PutMapping("/modifyEtudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant c) {
        return iEtudiantService.modifyEtudiant(c);
    }
}
