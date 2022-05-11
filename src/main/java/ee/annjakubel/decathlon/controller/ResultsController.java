package ee.annjakubel.decathlon.controller;

import ee.annjakubel.decathlon.model.Athlete;
import ee.annjakubel.decathlon.repository.AthleteRepository;
import ee.annjakubel.decathlon.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("decathlon/onehundredmeters")
    public ResponseEntity<Athlete> saveOneHundredMetersResult(@RequestBody Athlete athlete) {
        resultsService.updateOneHundredMetersResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }

    @PutMapping("decathlon/longjump")
    public ResponseEntity<Athlete> getLongJumpResult(@RequestBody Athlete athlete) {
        resultsService.updateLongJumpResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }

    @PutMapping("decathlon/shotput")
    public ResponseEntity<Athlete> getShotPutResult(@RequestBody Athlete athlete) {
        resultsService.updateShotPutResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }

    @PutMapping("decathlon/highjump")
    public ResponseEntity<Athlete> getHighJumpResult(@RequestBody Athlete athlete) {
        resultsService.updateHighJumpResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }
    @PutMapping("decathlon/fourhundredmeters")
    public ResponseEntity<Athlete> getFourHundredMeters(@RequestBody Athlete athlete) {
        resultsService.updateFourHundredMetersResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }

    @PutMapping("decathlon/hurdles")
    public ResponseEntity<Athlete> getHurdlesResult(@RequestBody Athlete athlete) {
        resultsService.updateHurdlesResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());

    }

    @PutMapping("decathlon/discusthrow")
    public ResponseEntity<Athlete> getDiscusThrowResult(@RequestBody Athlete athlete) {
        resultsService.updateDiscusThrowResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());

    }

    @PutMapping("decathlon/polevault")
    public ResponseEntity<Athlete> getPoleVaultResult(@RequestBody Athlete athlete) {
        resultsService.updatePoleVaultResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());

    }

    @PutMapping("decathlon/javelinthrow")
    public ResponseEntity<Athlete> getJavelinThrowResult(@RequestBody Athlete athlete) {
        resultsService.updateJavelinThrowResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());

    }

    @PutMapping("decathlon/fifteenhundredmeters")
    public ResponseEntity<Athlete> getFifteenHundredMetersResult(@RequestBody Athlete athlete) {
        resultsService.updateFifteenHundredMetersResult(athlete);
        return ResponseEntity.ok().body(athleteRepository.findById(athlete.getId()).get());
    }

}
