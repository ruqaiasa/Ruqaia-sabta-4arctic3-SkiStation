package tn.esprit.skistation.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Registration;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.services.IRegistrationService;

import java.util.List;

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


    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @GetMapping("/get/{numRegistration}")
    public Registration getRegistration(@PathVariable Long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }

    @GetMapping("/get")
    public List<Registration> getRegistrations() {
        return registrationService.retrieveAll();
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @DeleteMapping("/delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationService.removeRegistration(numRegistration);

    }



    @PostMapping("/addR/course/{numCourse}")
    public Registration assignRegistrationToCourse(@RequestBody Registration registration, @PathVariable Long numCourse) {
        return registrationService.assignRegistrationToCourse(registration, numCourse);
    }
    @PostMapping("/addSkier/AssignCourse/{numCourse}")
    public Skier addSkierAndAssignToCourse(@RequestBody Skier skier, @PathVariable Long numCourse){

        return registrationService.addSkierAndAssignToCourse(skier, numCourse);
    }
}
