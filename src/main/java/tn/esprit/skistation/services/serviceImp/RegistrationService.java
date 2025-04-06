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

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final RegistrationRepository registrationRepository;
    private final SkierRepository skierRepository;
    private  final CourseRepository courseRepository;
    public Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkieur
    ) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        if(skier != null)
            registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(Long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public List<Registration> retrieveAll() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public void removeRegistration(Long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }



    @Override
    public Registration assignRegistrationToCourse(Registration registration, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Skier savedSkier = skierRepository.save(skier);
        Course course = courseRepository.findById(numCourse)
                .orElse(null);

        Registration registration = new Registration();
        registration.setSkier(savedSkier);
        registration.setCourse(course);

        registrationRepository.save(registration);

        savedSkier.getRegistrations().add(registration);
        return skierRepository.save(savedSkier);
    }

}
