package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.entity.Skier;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    Piste retrievePiste(Long numPiste);

    Piste assignSkierToPiste(Long numSkier, Long numPiste);
    public void removePiste(Long numPiste) ;

    }

