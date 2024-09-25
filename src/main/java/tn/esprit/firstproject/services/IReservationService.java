package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(String ReservationId);
    public Reservation addReservation(Reservation c);
    public void removeReservation(String ReservationId);
    public Reservation modifyReservation(Reservation Reservation);
    public List<Reservation> findForReservation(long idBloc);
    List<Reservation> findByAnneeUniversitaire_YearAndNomUnuiversite(int anneeUniversitaire, String nomUniversite);
}
