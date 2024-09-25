package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.Reservation;
import tn.esprit.firstproject.entities.TypeChambre;
import tn.esprit.firstproject.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    @Autowired
    IReservationService iReservationService;

    @GetMapping("/getAll")
    public List<Reservation> listAll(){
        return iReservationService.retrieveAllReservations();
    }

    @GetMapping("/getReservation/{idReservation}")
    public Reservation retrieveReservation(@PathVariable("idReservation") String chId) {
        return iReservationService.retrieveReservation(chId);
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        return iReservationService.addReservation(c);
    }

    @DeleteMapping("/removeReservation/{idReservation}")
    public void removeReservation(@PathVariable("idReservation") String chId) {
        iReservationService.removeReservation(chId);
    }

    @PutMapping("/modifyReservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        return iReservationService.modifyReservation(c);
    }

    @GetMapping("/getReservationBloc/{idBloc}")
    public List<Reservation>  retrieveReservationBloc(@PathVariable("idBloc") Long idBloc) {
        return iReservationService.findForReservation(idBloc);
    }

    @GetMapping("/getReservationParAnneeEtUniversite/{anneeUniversitaire}/{nomUniversite}")
    public List<Reservation> getReservationParAnneeEtUniversite(@PathVariable int anneeUniversitaire, @PathVariable String nomUniversite) {
        return iReservationService.findByAnneeUniversitaire_YearAndNomUnuiversite(anneeUniversitaire, nomUniversite);
    }
}
