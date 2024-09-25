package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer, Long> {
    public Foyer findByUniversite(Universite u);

    public List<Foyer> findByNomFoyer(String nom);
}
