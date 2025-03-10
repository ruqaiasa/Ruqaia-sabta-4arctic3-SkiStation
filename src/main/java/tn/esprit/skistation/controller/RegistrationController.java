package tn.esprit.skistation.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Registration;
import tn.esprit.skistation.services.IRegistrationService;

@RestController
@RequestMapping("registration")
@RequiredArgsConstructor

public class RegistrationController {

    private final IRegistrationService registrationService;

    @PostMapping("add-registration/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(
            @RequestBody Registration registration,
            @PathVariable(name = "numSkier") Long numSkier
    ) {
        return registrationService.addRegistrationAndAssignToSkier(registration, numSkier);
    }
}
