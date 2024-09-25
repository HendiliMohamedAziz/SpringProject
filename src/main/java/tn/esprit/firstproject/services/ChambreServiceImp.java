package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.entities.Chambre;
import tn.esprit.firstproject.entities.TypeChambre;
import tn.esprit.firstproject.repositories.IBlocRepository;
import tn.esprit.firstproject.repositories.IChambreRepository;

import java.util.List;

@Service
@Slf4j
public class ChambreServiceImp implements IChambreService{
    @Autowired
    IChambreRepository iChambreRepository;
    @Autowired
    IBlocRepository iBlocRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> chambres = (List<Chambre>) iChambreRepository.findAll();
        for (Chambre chambre: chambres){
            log.info("chambre :" + chambre);
        }
        return chambres;
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return iChambreRepository.findById(chambreId).orElse(null);
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return iChambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        iChambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return iChambreRepository.save(chambre);
    }


    @Override
    public Bloc affecterChambresABloc(List<Long> idChambres, long idBloc) {
        Bloc bloc = iBlocRepository.findById(idBloc).orElse(null);

        long availableCapacity = bloc.getCapaciteBloc() - bloc.getChambres().size();

        long chambresToAdd = Math.min(availableCapacity, idChambres.size());

        for (int i = 0; i < chambresToAdd; i++) {
            Long chambreId = idChambres.get(i);
            Chambre chambre = iChambreRepository.findById(chambreId).orElse(null);

            chambre.setBloc(bloc);
            iChambreRepository.save(chambre);

        }

        if (chambresToAdd < idChambres.size()) {
            log.warn("Not enough capacity to accommodate all chambres. Added only {} chambres.", chambresToAdd);
        }


        return bloc;
    }


    @Override
    public List<Chambre>  getChambresParNomUniversite(String nomUniversite){
        return iChambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return iChambreRepository.getChambresParBlocEtType(idBloc, typeC);
    }
}
