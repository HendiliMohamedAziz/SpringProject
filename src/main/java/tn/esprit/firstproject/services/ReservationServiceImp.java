package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Reservation;
import tn.esprit.firstproject.repositories.IReservationRepository;

import java.util.List;

@Service
@Slf4j
public class ReservationServiceImp implements IReservationService{
    @Autowired
    IReservationRepository iReservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        List<Reservation> reservations = (List<Reservation>) iReservationRepository.findAll();
        for (Reservation reservation: reservations){
            log.info("reservation :" + reservation);
        }
        return reservations;
    }

    @Override
    public Reservation retrieveReservation(String ReservationId) {
        return iReservationRepository.findById(ReservationId).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return iReservationRepository.save(c);
    }

    @Override
    public void removeReservation(String ReservationId) {
        iReservationRepository.deleteById(ReservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation Reservation) {
        return iReservationRepository.save(Reservation);
    }

    @Override
    public List<Reservation> findForReservation(long idBloc) {
        return iReservationRepository.findByChambresBlocIdBloc2(idBloc);
    }

    @Override
    public List<Reservation> findByAnneeUniversitaire_YearAndNomUnuiversite(int anneeUniversitaire, String nomUniversite) {
        return iReservationRepository.findByYearAndNomUniversite1(anneeUniversitaire, nomUniversite);
    }
}
