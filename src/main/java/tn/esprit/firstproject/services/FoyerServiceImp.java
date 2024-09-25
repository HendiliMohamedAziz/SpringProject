package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IFoyerRepository;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@Slf4j
public class FoyerServiceImp implements IFoyerService{
    @Autowired
    IFoyerRepository iFoyerRepository;
    @Autowired
    IUniversiteRepository iUniversiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        List<Foyer> foyers = (List<Foyer>) iFoyerRepository.findAll();
        for (Foyer foyer: foyers){
            log.info("foyer :" + foyer);
        }
        return foyers;
    }

    @Override
    public Foyer retrieveFoyer(Long FoyerId) {
        return iFoyerRepository.findById(FoyerId).orElse(null);
    }

    @Override
    public Foyer addFoyer(Foyer c) {
        return iFoyerRepository.save(c);
    }

    @Override
    public void removeFoyer(Long FoyerId) {
        iFoyerRepository.deleteById(FoyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer Foyer) {
        return iFoyerRepository.save(Foyer);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, long idUniversite){
        Universite universite = iUniversiteRepository.findById(idUniversite).get();
        Foyer foyer = iFoyerRepository.findById(idFoyer).get();
        foyer.setUniversite(universite);
        iFoyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = iUniversiteRepository.findById(idUniversite).orElse(null);

        if (universite != null && universite.getFoyer() != null) {
            universite.getFoyer().setUniversite(null);
            iFoyerRepository.save(universite.getFoyer());
        }

        return universite;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite){
        Foyer foyer1 = iFoyerRepository.save(foyer);
        affecterFoyerAUniversite(foyer1.getIdFoyer(), idUniversite);
        return foyer;
    }
}
