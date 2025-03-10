package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skistation.entity.Skier;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
}
