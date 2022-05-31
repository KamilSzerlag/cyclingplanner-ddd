package pl.ksz.cyclingplanner.template.domain;

import java.util.UUID;
import pl.ksz.cyclingplanner.util.ValueObject;

@ValueObject
public record AthleteId(UUID id) {

}
