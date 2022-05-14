package ee.annjakubel.decathlon.model.output;

import lombok.Data;

import java.util.Date;

@Data
public class AuthData {
    private String token;
    private Date expiration;
}
