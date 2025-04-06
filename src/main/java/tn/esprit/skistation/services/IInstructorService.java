package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Instructor;

import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> retrieveAll();
    void removeInstructor(Long numInstructor);
    Instructor addInstructorAndAssignToCourses(Instructor instructor, List<Long> numCourses);
    Instructor addAndAssignCourses(Instructor instructor);
}
