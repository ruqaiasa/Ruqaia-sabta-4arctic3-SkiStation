package tn.esprit.skistation.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Instructor;
import tn.esprit.skistation.services.IInstructorService;
import tn.esprit.skistation.services.IInstructorService;

import java.util.List;

@RestController
@RequestMapping("instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final IInstructorService instructorService;


    @Operation(description = "Ajouter un Instructor")
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @Operation(description = "Récupérer un Instructor par id")
    @GetMapping("/get/{numInstructor}")
    public Instructor getInstructor(@PathVariable Long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }

    @Operation(description = "Récuperer tous les instructors")
    @GetMapping("/get")
    public List<Instructor> getInstructors() {
        return instructorService.retrieveAll();
    }

    @Operation(description = "Modifier un Instructor")
    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @Operation(description = "Supprimer un Instructor")
    @DeleteMapping("/delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorService.removeInstructor(numInstructor);

    }
    @PostMapping("/add/assignCourse/{numCourses}")
    public Instructor addInstructorAndAssignToCourses(@RequestBody Instructor instructor,@PathVariable List<Long> numCourses)
    {
        return instructorService.addInstructorAndAssignToCourses(instructor, numCourses);
    }
    @PostMapping("/addAndAssign/Courses")
    public Instructor addAndAssignCourses(@RequestBody Instructor instructor)
    {
        return instructorService.addAndAssignCourses(instructor);
    }


}
