package tn.esprit.skistation.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.repositories.CourseRepository;
import tn.esprit.skistation.services.ICourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository repository;

    public List<Course> retrieveAllCourses() {
        return repository.findAll();
    }
    public Course addCourse(Course course) {
        return repository.save(course);
    }
    public Course updateCourse(Course course) {
        return repository.save(course);
    }
    public Course retrieveCourse(Long numCourse) {
        return repository.findById(numCourse).orElse(null);
    }

}
