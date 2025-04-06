package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.enums.TypeCourse;
import tn.esprit.skistation.enums.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
    List<Skier> findBySubscription(TypeSubscription subscriptionType);

    List<Skier> getSkierByTypeCourse(TypeCourse typeCourse);

    Skier findByFirstNameAndLastName(String firstName, String lastName);

    List<Skier> findByDateOfBirth(LocalDate dob);
}
