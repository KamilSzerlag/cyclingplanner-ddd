package pl.ksz.cyclingplanner.template.domain;

import jakarta.validation.constraints.Max;

/**
 * Value Object
 */
public record WorkoutTemplateName(@Max(value = 500) String value) {

}
