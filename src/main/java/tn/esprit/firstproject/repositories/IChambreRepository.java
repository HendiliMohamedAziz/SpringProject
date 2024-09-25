package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre, Long> {
    public List<Chambre> findByReservationsIsNull();

    public  List<Chambre> findByTypeCLike(TypeChambre type);

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> findByBlocFoyerUniversiteNomUniversite1(@Param("nomUniversite") String nomUniversite);
    //2eme methode keywords
    List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUniversite);

    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.idBloc = :idBloc " +
            "AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    //2eme methode keyword
    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);
}
