package tn.esprit.skistation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.entity.Skier;
import tn.esprit.skistation.services.IPisteService;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.services.IPisteService;

import java.util.List;

@RestController
@RequestMapping("piste")
@RequiredArgsConstructor
public class PisteController {

    private final IPisteService pisteService;




    @PatchMapping("assign-skier-to-piste")
    public Piste assignSkierToPiste(
            @RequestParam Long numSkier,
            @RequestParam Long numPiste
    ) {
        return pisteService.assignSkierToPiste(numSkier, numPiste);
    }

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @GetMapping("/get/{numPiste}")
    public Piste getPiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @GetMapping("/get")
    public List<Piste> getPistes() {
        return pisteService.retrieveAllPistes();
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.removePiste(numPiste);

    }


}
