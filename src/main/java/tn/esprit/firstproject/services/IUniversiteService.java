package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Foyer;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long UniversiteId);
    public Universite addUniversite(Universite c);
    public void removeUniversite(Long UniversiteId);
    public Universite modifyUniversite(Universite Universite);
}
