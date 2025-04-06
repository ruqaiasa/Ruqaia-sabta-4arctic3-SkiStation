package tn.esprit.skistation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.services.ICourseService;

import java.util.List;

    @RequiredArgsConstructor
    @RequestMapping("course")
    @RestController
    public class CourseController {

        private final ICourseService courseServices;

        @PostMapping("/add")
        public Course saveCourse(@RequestBody Course course) {
            return courseServices.addCourse(course);
        }

        @GetMapping("/get/{numCourse}")
        public Course getCourse(@PathVariable Long numCourse) {
            return courseServices.retrieveCourse(numCourse);
        }

        @GetMapping("/get")
        public List<Course> getCourses() {
            return courseServices.retrieveAllCourses();
        }

        @PutMapping("/update")
        public Course updateCourse(@RequestBody Course course) {
            return courseServices.updateCourse(course);
        }

        @DeleteMapping("/delete/{numCourse}")
        public void deleteCourse(@PathVariable Long numCourse) {
            courseServices.removeCourse(numCourse);

        }
    }


