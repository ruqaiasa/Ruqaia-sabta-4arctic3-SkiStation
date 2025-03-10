package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> retrieveAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long numCourse);
}
