package ee.annjakubel.decathlon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private int age;
    //sports
    private int oneHundredMeters;
    private int longJump;
    private int shotPut;
    private int highJump;
    private int fourHundredMeters;
    private int hurdles;
    private int discusThrow;
    private int poleVault;
    private int javelinThrow;
    private int fifteenHundredMeters;
    private int pointsSum;
}
