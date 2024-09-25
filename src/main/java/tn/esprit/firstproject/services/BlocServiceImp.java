package tn.esprit.firstproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Bloc;
import tn.esprit.firstproject.repositories.IBlocRepository;

import java.util.List;

@Service
@Slf4j
public class BlocServiceImp implements IBlocService {
    @Autowired
    IBlocRepository iBlocRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> blocs = (List<Bloc>) iBlocRepository.findAll();
        for (Bloc bloc: blocs){
            log.info("bloc :" + bloc);
        }
        return blocs;
    }

    @Override
    public Bloc retrieveBloc(Long BlocId) {
        log.info("Retrieving bloc with ID: {}", BlocId);
        return iBlocRepository.findById(BlocId).orElse(null);
    }

    @Override
    public Bloc addBloc(Bloc c) {
        log.info("Adding a new bloc: {}", c);
        return iBlocRepository.save(c);
    }

    @Override
    public void removeBloc(Long BlocId) {
        log.info("Removing bloc with ID: {}", BlocId);
        iBlocRepository.deleteById(BlocId);
    }

    @Override
    public Bloc modifyBloc(Bloc Bloc) {
        log.info("Modifying bloc: {}", Bloc);
        return iBlocRepository.save(Bloc);
    }

    @Override
    public List<Bloc> findIdUniv(long idUniversite) {
        return iBlocRepository.findByBlocFoyerUniversiteIdUniversite(idUniversite);
    }
}
