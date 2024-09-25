package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.TypeChambre;
import tn.esprit.firstproject.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/Chambre")
public class ChambreController {
    @Autowired
    IChambreService iChambreService;

    @GetMapping("/getAll")
    public List<Chambre> listAll(){
        return iChambreService.retrieveAllChambres();
    }

    @GetMapping("/getchambre/{idChambre}")
    public Chambre retrieveChambre(@PathVariable("idChambre") Long chId) {
        return iChambreService.retrieveChambre(chId);
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/removeChambre/{idChambre}")
    public void removeChambre(@PathVariable("idChambre") Long chId) {
        iChambreService.removeChambre(chId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/modifyChambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        return iChambreService.modifyChambre(c);
    }

    @PutMapping("/affecterchambresabloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> idChambres, @PathVariable long idBloc) {
        return iChambreService.affecterChambresABloc(idChambres, idBloc);
    }

    @GetMapping("/getChambreuniversite/{nomUniversite}")
    public List<Chambre> getChambreUniversite(@PathVariable String nomUniversite){
        return iChambreService.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeChambre typeC) {
        return iChambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}
