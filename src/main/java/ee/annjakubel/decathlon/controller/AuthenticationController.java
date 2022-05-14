package ee.annjakubel.decathlon.controller;

import ee.annjakubel.decathlon.authentication.TokenGenerator;
import ee.annjakubel.decathlon.model.database.Person;
import ee.annjakubel.decathlon.model.input.LoginData;
import ee.annjakubel.decathlon.model.output.AuthData;
import ee.annjakubel.decathlon.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenGenerator tokenGenerator;

    @PostMapping("decathlon/signup")
    public ResponseEntity<Boolean> signup(@RequestBody Person person) {
        String hashedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(hashedPassword);
        personRepository.save(person);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("decathlon/login")
    public ResponseEntity<AuthData> login(@RequestBody LoginData loginData) {
        Person person = personRepository.getByEmail(loginData.getEmail());
        boolean matches = passwordEncoder.matches(loginData.getPassword(), person.getPassword());
        if (matches) {
            AuthData authData = tokenGenerator.createAuthToken(loginData.getEmail());
            return ResponseEntity.ok().body(authData);
        }
        return ResponseEntity.ok().body(null);
    }
}
