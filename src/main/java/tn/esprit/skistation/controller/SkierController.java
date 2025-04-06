package tn.esprit.skistation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.enums.TypeCourse;
import tn.esprit.skistation.enums.TypeSubscription;
import tn.esprit.skistation.services.ISkierService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("skier")
@RequiredArgsConstructor
public class SkierController {
    private final ISkierService skierService;

    @PostMapping("add-skier")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @GetMapping("get-all-skiers")
    public List<Skier> getAllSkiers() {
        return skierService.retrieveAllSkiers();
    }

    @GetMapping("get-one-skier")
    public Skier getSkier(@RequestParam Long numSkier) {
        return skierService.retrieveSkier(numSkier);
    }

    @DeleteMapping("delete-skier")
    public ResponseEntity<String> deleteSkier(@RequestParam Long numSkier) {
        skierService.removeSkier(numSkier);
        return ResponseEntity.ok().body("Skier deleted successfully");
    }

    @PostMapping("add-skier-course/{numCourse}")
    public Skier addSkierAndAssignToCourse(
            @RequestBody  Skier skier, @PathVariable(name = "numCourse") Long numCourse
    ){
        return skierService.addSkierAndAssignToCourse(skier, numCourse);
    }




    @PutMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    @PutMapping("/assignToPiste/{numSkier}/{numPiste}")
    public void assignSkier(@PathVariable Long numSkier,@PathVariable Long numPiste) {
        skierService.assignSkierToPiste(numSkier, numPiste);
    }
    @GetMapping("/get/{firstName}/{lastName}")
    public Skier getByFLname(@PathVariable String firstName, @PathVariable String lastName) {
        return skierService.getByFirstAndLastName(firstName, lastName);
    }
    @GetMapping("/getByDob/{dob}")
    public List<Skier> getByDob(@PathVariable LocalDate dob) {
        return skierService.getByDateOfBirth(dob);
    }
    @GetMapping("/getskier/subscription/{subscriptionType}")
    List<Skier> retrieveSkiersBySubscriptionType(@PathVariable TypeSubscription subscriptionType){
        return skierService.retrieveSkiersBySubscriptionType(subscriptionType);
    }
    @GetMapping("/getskier/cours/{typeCourse}")
    List<Skier> getSkierByTypeCourse(@PathVariable TypeCourse typeCourse){
        return skierService.getSkierByTypeCourse(typeCourse);
    }
}
