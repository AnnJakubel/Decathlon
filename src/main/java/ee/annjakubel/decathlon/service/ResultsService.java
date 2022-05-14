package ee.annjakubel.decathlon.service;

import ee.annjakubel.decathlon.model.database.Athlete;
import ee.annjakubel.decathlon.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsService {

    // TODO: Liiguta Putmappingu kood siia Service alla
    @Autowired
    AthleteRepository athleteRepository;

    public Athlete updateOneHundredMetersResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setOneHundredMeters(athleteFromRest.getOneHundredMeters());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateLongJumpResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setLongJump(athleteFromRest.getLongJump());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateShotPutResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setShotPut(athleteFromRest.getShotPut());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateHighJumpResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setHighJump(athleteFromRest.getHighJump());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateFourHundredMetersResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setFourHundredMeters(athleteFromRest.getFourHundredMeters());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateHurdlesResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setHurdles(athleteFromRest.getHurdles());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateDiscusThrowResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setDiscusThrow(athleteFromRest.getDiscusThrow());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updatePoleVaultResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setPoleVault(athleteFromRest.getPoleVault());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateJavelinThrowResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setJavelinThrow(athleteFromRest.getJavelinThrow());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    public Athlete updateFifteenHundredMetersResult(Athlete athleteFromRest) {
        Athlete updatedAthlete = athleteRepository.findById(athleteFromRest.getId()).get();
        updatedAthlete.setFifteenHundredMeters(athleteFromRest.getFifteenHundredMeters());
        updatedAthlete.setPointsSum(getPointsSum(athleteFromRest));
        athleteRepository.save(updatedAthlete);
        return updatedAthlete;
    }

    private int getPointsSum(Athlete athleteFromRest) {
        int sum = athleteFromRest.getOneHundredMeters()
                + athleteFromRest.getLongJump()
                + athleteFromRest.getShotPut()
                + athleteFromRest.getHighJump()
                + athleteFromRest.getFourHundredMeters()
                + athleteFromRest.getHurdles()
                + athleteFromRest.getDiscusThrow()
                + athleteFromRest.getPoleVault()
                + athleteFromRest.getJavelinThrow()
                + athleteFromRest.getFifteenHundredMeters();

        return sum;
    }



   /* public int resultToPoints(double result) {

    }*/
}
