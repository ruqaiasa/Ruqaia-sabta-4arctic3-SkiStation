package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Skier;

import java.util.List;

public interface ISkierService {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    void removeSkier (Long numSkier);
    Skier retrieveSkier (Long numSkier);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
}
