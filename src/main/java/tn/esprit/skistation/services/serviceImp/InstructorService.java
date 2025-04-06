package tn.esprit.skistation.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.entity.Instructor;
import tn.esprit.skistation.repositories.CourseRepository;
import tn.esprit.skistation.repositories.InstructorRepository;
import tn.esprit.skistation.services.IInstructorService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InstructorService implements IInstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
/*
    public List<Instructor> retrieveInstructors() {
        return repository.findAll();
    }
    public Instructor addInstructor(Instructor instructor) {
        return repository.save(instructor);
    }
    public Instructor updateInstructor (Instructor instructor) {
        return repository.save(instructor);
    }
    public Instructor retrieveInstructor (Long numInstructor) {
        return repository.findById(numInstructor).orElse(null);
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        if(course != null) {
            instructor.getCourses().add(course);
        }
        return repository.save(instructor);
    }
    */
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public List<Instructor> retrieveAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public Instructor addInstructorAndAssignToCourses(Instructor instructor, List<Long> numCourses) {
        Set<Course> courses = new HashSet<>();
        for (Long courseId : numCourses) {
            Course course = courseRepository.findById(courseId).orElse(null);
            if (course != null) {
                instructor.getCourses().add(course);
            }
        }
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor addAndAssignCourses(Instructor instructor) {

        Set<Course> assignedCourses = new HashSet<>();
        for (Course course : instructor.getCourses()) {
            Long courseId = course.getNumCourse();
            Course foundCourse = courseRepository.findById(courseId).orElse(null);

            if (foundCourse != null) {
                assignedCourses.add(foundCourse);
            }
        }
        instructor.setCourses(assignedCourses);
        return instructorRepository.save(instructor);
    }


}
