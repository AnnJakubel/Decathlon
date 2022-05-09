package ee.annjakubel.decathlon.service;

import ee.annjakubel.decathlon.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsService {

    @Autowired
    AthleteRepository athleteRepository;


    public boolean checkIfInRepository(Long id) {
        return athleteRepository.existsById(id);
    }

   /* public int resultToPoints(double result) {

    }*/
}
