package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Instructor;

import java.util.List;

public interface IInstructorService {
    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (Long numInstructor);
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long
            numCourse);
}
