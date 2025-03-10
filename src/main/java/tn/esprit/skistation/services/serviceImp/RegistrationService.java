package tn.esprit.skistation.services.serviceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.entity.Registration;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.repositories.RegistrationRepository;
import tn.esprit.skistation.repositories.SkierRepository;
import tn.esprit.skistation.services.IRegistrationService;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final RegistrationRepository registrationRepository;
    private final SkierRepository skierRepository;
    public Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkieur
    ) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        if(skier != null)
            registration.setSkier(skier);
        return registrationRepository.save(registration);
    }
}
