package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Reservation;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IFoyerRepository;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@Slf4j
public class UniversiteServiceImp implements IUniversiteService{
    @Autowired
    IUniversiteRepository iUniversiteRepository;
    @Autowired
    IFoyerRepository iFoyerRepository;


    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universites = (List<Universite>) iUniversiteRepository.findAll();
        for (Universite universite: universites){
            log.info("universite :" + universite);
        }
        return universites;
    }

    @Override
    public Universite retrieveUniversite(Long UniversiteId) {
        return iUniversiteRepository.findById(UniversiteId).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite c) {
        return iUniversiteRepository.save(c);
    }

    @Override
    public void removeUniversite(Long UniversiteId) {
        iUniversiteRepository.deleteById(UniversiteId);
    }

    @Override
    public Universite modifyUniversite(Universite Universite) {
        return iUniversiteRepository.save(Universite);
    }
}
