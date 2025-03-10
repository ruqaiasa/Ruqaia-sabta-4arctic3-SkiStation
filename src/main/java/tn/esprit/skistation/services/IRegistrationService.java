package tn.esprit.skistation.services;

import tn.esprit.skistation.entity.Registration;

public interface IRegistrationService {
    Registration addRegistrationAndAssignToSkier(
            Registration registration, Long numSkieur
    );
}
