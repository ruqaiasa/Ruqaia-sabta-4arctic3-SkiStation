package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.enums.Color;

import java.util.List;

@Repository
public interface PisteRepository extends CrudRepository<Piste, Long> {
    List<Piste> findByColor(Color color);
}
