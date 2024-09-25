package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.TypeChambre;

import java.util.List;


public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public Bloc affecterChambresABloc(List<Long> idChambre, long idBloc) ;
    public List<Chambre>  getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;
}
