package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Etudiant;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Long> {
    public List<Etudiant> findByNomEtAndPrenomEt(String x, String y);

    public List<Etudiant> findByAgeGreaterThan(int a);
}
