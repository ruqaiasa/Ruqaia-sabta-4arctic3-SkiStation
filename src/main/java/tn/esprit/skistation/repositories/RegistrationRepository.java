package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skistation.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
