package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/Bloc")
public class BlocController {
    @Autowired
    IBlocService iBlocService;

    @GetMapping("/getAll")
    public List<Bloc> listAll(){
        return iBlocService.retrieveAllBlocs();
    }

    @GetMapping("/getBloc/{idBloc}")
    public Bloc retrieveBloc(@PathVariable("idBloc") Long chId) {
        return iBlocService.retrieveBloc(chId);
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        return iBlocService.addBloc(c);
    }

    @DeleteMapping("/removeBloc/{idBloc}")
    public void removeBloc(@PathVariable("idBloc") Long chId) {
        iBlocService.removeBloc(chId);
    }

    @PutMapping("/modifyBloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        return iBlocService.modifyBloc(c);
    }

    @GetMapping("/getBlocuniversite/{idUniversite}")
    public List<Bloc> getBlocUniversite(@PathVariable Long idUniversite){
        return iBlocService.findIdUniv(idUniversite);
    }
}
