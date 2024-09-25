package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import java.util.List;

@Service
@Slf4j
public class EtudiantServiceImp implements IEtudiantService{
    @Autowired
    IEtudiantRepository iEtudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiants = (List<Etudiant>) iEtudiantRepository.findAll();
        for (Etudiant etudiant: etudiants){
            log.info("etudiant :" + etudiant);
        }
        return etudiants;
    }

    @Override
    public Etudiant retrieveEtudiant(Long EtudiantId) {
        return iEtudiantRepository.findById(EtudiantId).orElse(null);
    }

    @Override
    public Etudiant addEtudiant(Etudiant c) {
        return iEtudiantRepository.save(c);
    }

    @Override
    public void removeEtudiant(Long EtudiantId) {
        iEtudiantRepository.deleteById(EtudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant Etudiant) {
        return iEtudiantRepository.save(Etudiant);
    }
}
