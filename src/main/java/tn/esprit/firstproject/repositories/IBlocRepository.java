package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.Foyer;

import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc, Long> {
    public List<Bloc> findByFoyer(Foyer f);

    public List<Bloc> findByCapaciteBlocBetween(Long c1, Long c2);

    @Query("SELECT b FROM Bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.idUniversite = :idUniversite")
    List<Bloc> findByBlocFoyerUniversiteIdUniversite(@Param("idUniversite") Long idUniversite);

    //2eme methode keywords
    List<Bloc> findByFoyerUniversiteIdUniversite(Long idUniversite);
}
