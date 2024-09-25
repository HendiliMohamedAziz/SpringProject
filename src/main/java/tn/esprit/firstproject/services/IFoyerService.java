package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long FoyerId);
    public Foyer addFoyer(Foyer c);
    public void removeFoyer(Long FoyerId);
    public Foyer modifyFoyer(Foyer Foyer);
    public Universite affecterFoyerAUniversite (long idFoyer, long idUniversite);
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
