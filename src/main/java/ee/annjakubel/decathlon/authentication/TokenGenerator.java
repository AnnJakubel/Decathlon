package ee.annjakubel.decathlon.authentication;

import ee.annjakubel.decathlon.model.output.AuthData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {
    @Value("${token.key}")
    private String key;

    public AuthData createAuthToken(String email) {
        AuthData authData = new AuthData();
        Date newDate = DateUtils.addHours(new Date(), 5);

        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, key)
                .setIssuer("decathlon")
                .setSubject(email)
                .setExpiration(newDate)
                .compact();

        authData.setToken(token);
        authData.setExpiration(newDate);
        return authData;
    }
}
