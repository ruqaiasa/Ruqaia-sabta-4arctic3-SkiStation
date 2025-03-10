package tn.esprit.skistation.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Course;
import tn.esprit.skistation.entity.Registration;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.repositories.CourseRepository;
import tn.esprit.skistation.repositories.RegistrationRepository;
import tn.esprit.skistation.repositories.SkierRepository;
import tn.esprit.skistation.services.IRegistrationService;
import tn.esprit.skistation.services.ISkierService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkierService implements ISkierService {

    private final SkierRepository repository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;
    private final IRegistrationService registrationService;

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
}
