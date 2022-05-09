package ee.annjakubel.decathlon.controller;

import ee.annjakubel.decathlon.model.Athlete;
import ee.annjakubel.decathlon.repository.AthleteRepository;
import ee.annjakubel.decathlon.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResultsController {

    /*


     */
    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    ResultsService resultsService;

    @PostMapping("decathlon/athlete")
    public ResponseEntity<Athlete> saveAthlete(@RequestBody Athlete athlete) {
        athleteRepository.save(athlete);
        Long id = athlete.getId();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(athleteRepository.getById(id));
    }

    @GetMapping("decathlon/athletes")
    public ResponseEntity<List<Athlete>> getAllAthletes() {
        return ResponseEntity.ok().body(athleteRepository.findAll());
    }


    //RequestParam!
    @PostMapping("onehundredmeters/{id}/{value}")
    public ResponseEntity<Athlete> saveOneHundredMetersResult(@PathVariable Long id,
                                                                    @PathVariable int value) {

        Athlete updatedAthlete = athleteRepository.getById(id);
        updatedAthlete.setOneHundredMeters(value);
        athleteRepository.save(updatedAthlete);

        return ResponseEntity.ok().body(updatedAthlete);
    }

    /*@PostMapping
    public void getLongJumpResult() {

    }

    @PostMapping
    public void getShotPutResult() {

    }

    @PostMapping
    public void getHighJumpResult() {

    }
    @PostMapping
    public void getFourHundredMeters() {
    }

    @PostMapping
    public void getHurdlesResult() {

    }

    @PostMapping
    public void getDiscusThrowResult() {

    }

    @PostMapping
    public void getPoleVaultResult() {

    }

    @PostMapping
    public void getJavelinThrowResult() {

    }

    @PostMapping
    public void getFifteenHundredMetersResult() {
    }*/

}
