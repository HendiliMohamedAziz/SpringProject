package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, String> {
    public List<Reservation> findByAnneeUniversitaireBetween(Date d1, Date d2);

    public List<Reservation> findByAnneeUniversitaireLessThan(Date d);
    @Query(nativeQuery = true, value = "SELECT r.* FROM reservation r "
            + "JOIN chambre_reservations cr ON r.id_reservation = cr.reservations_id_reservation "
            + "JOIN chambre c ON cr.chambre_id_chambre = c.id_chambre "
            + "WHERE c.bloc_id_bloc = :idBloc")
    public List<Reservation> findByChambresBlocIdBloc1(Long idBloc);
    //2eme methode
    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r MEMBER OF c.reservations " +
            "WHERE c.bloc.idBloc = :idBloc")
    public List<Reservation> findByChambresBlocIdBloc2(@Param("idBloc") Long idBloc);

    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r MEMBER OF c.reservations " +
            "WHERE c.bloc.idBloc = :idBloc " +
            "AND YEAR(r.anneeUniversitaire) = YEAR(CURRENT_DATE) " +
            "AND r.estValide = true")
    public List<Reservation> findByChambresBlocIdBlocResValideYear(@Param("idBloc") Long idBloc);


    @Query(nativeQuery = true, value = "SELECT r.* FROM reservation r "
            + "JOIN chambre_reservations cr ON r.id_reservation = cr.reservations_id_reservation "
            + "JOIN chambre c ON cr.chambre_id_chambre = c.id_chambre "
            + "JOIN bloc b ON c.bloc_id_bloc = b.id_bloc "
            + "JOIN foyer f ON b.foyer_id_foyer = f.id_foyer "
            + "JOIN universite u ON f.universite_id_universite = u.id_universite "
            + "WHERE YEAR(r.annee_universitaire) = :anneeUniversitaire "
            + "AND u.nom_universite = :nomUniversite")
    public List<Reservation> findByYearAndNomUniversite1(int anneeUniversitaire, String nomUniversite);

    //2eme methode
    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r MEMBER OF c.reservations " +
            "JOIN Bloc b ON c.bloc = b " +
            "JOIN Foyer f ON b.foyer = f " +
            "JOIN Universite u ON f.universite = u " +
            "WHERE YEAR(r.anneeUniversitaire) = :anneeUniversitaire " +
            "AND u.nomUniversite = :nomUniversite")
    public List<Reservation> findByYearAndNomUniversite2(int anneeUniversitaire, String nomUniversite);


    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r MEMBER OF c.reservations " +
            "JOIN Bloc b ON c.bloc = b " +
            "JOIN Foyer f ON b.foyer = f " +
            "JOIN Universite u ON f.universite = u " +
            "JOIN Etudiant e ON r MEMBER OF e.reservations " +
            "WHERE YEAR(r.anneeUniversitaire) = :anneeUniversitaire " +
            "AND e.cin = :cinEtudiant")
    public List<Reservation> findByEtudiantsCinEtudiantAndAnneeUniversitaire(long cinEtudiant, int anneeUniversitaire);

}
