package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
