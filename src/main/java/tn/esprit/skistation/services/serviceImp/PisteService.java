package tn.esprit.skistation.services.serviceImp;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.repositories.PisteRepository;
import tn.esprit.skistation.repositories.SkierRepository;
import tn.esprit.skistation.services.IPisteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteService implements IPisteService {

    private final PisteRepository repository;
    private final SkierRepository skierRepository;

    public List<Piste> retrieveAllPistes() {
        return (List<Piste>) repository.findAll();
    }
    public Piste addPiste(Piste piste) {
        return repository.save(piste);
    }
    public Piste updatePiste (Piste piste) {
        return repository.save(piste);
    }
    public Piste retrievePiste (Long numPiste) {
        return repository.findById(numPiste).orElse(null);
    }

    public Piste assignSkierToPiste(Long numSkier, Long numPiste) {
        Piste piste = repository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        if(piste != null && skier != null) {
            piste.getSkiers().add(skier);
            return repository.save(piste);
        }


        return null;
    }
    @Override
    public void removePiste(Long numPiste) {
        repository.deleteById(numPiste);
    }
}
