package tn.esprit.skistation.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.entity.Registration;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.enums.TypeCourse;
import tn.esprit.skistation.enums.TypeSubscription;
import tn.esprit.skistation.repositories.CourseRepository;
import tn.esprit.skistation.repositories.PisteRepository;
import tn.esprit.skistation.repositories.RegistrationRepository;
import tn.esprit.skistation.repositories.SkierRepository;
import tn.esprit.skistation.services.IRegistrationService;
import tn.esprit.skistation.services.ISkierService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkierService implements ISkierService {

    private final SkierRepository repository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;
    private final IRegistrationService registrationService;
    private final PisteRepository pisteRepository;

    public List<Skier> retrieveAllSkiers() {
        return repository.findAll();
    }
    public Skier addSkier(Skier skier) {
        return repository.save(skier);
    }
    public void removeSkier (Long numSkier) {
        repository.deleteById(numSkier);
    }
    public Skier retrieveSkier (Long numSkier) {
        return repository.findById(numSkier).orElse(null);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        skier.getRegistrations().forEach(r ->
                {
                    r.setCourse(course);
                    r.setSkier(skier);
                }
        );
        return repository.save(skier);
    }






    @Override
    public void assignSkierToPiste(Long numSkier, Long numPiste) {

        Skier skier = repository.findById(numSkier)
                .orElse(null);
        Piste piste = pisteRepository.findById(numPiste)
                .orElse(null);
        piste.getSkiers().add(skier);
        pisteRepository.save(piste);
    }

    @Override
    public Skier getByFirstAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<Skier> getByDateOfBirth(LocalDate dob) {
        return repository.findByDateOfBirth(dob);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription subscriptionType) {

        return  repository.findBySubscription(subscriptionType);

    }

    @Override
    public List<Skier> getSkierByTypeCourse(TypeCourse typeCourse) {
        return repository.getSkierByTypeCourse(typeCourse);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return repository.save(skier);

    }


}
