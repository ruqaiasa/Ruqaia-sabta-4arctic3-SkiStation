package tn.esprit.skistation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.services.IPisteService;
import tn.esprit.skistation.entity.Piste;
import tn.esprit.skistation.services.IPisteService;

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
}
