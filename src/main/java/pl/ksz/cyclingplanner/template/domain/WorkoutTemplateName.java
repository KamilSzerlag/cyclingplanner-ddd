package pl.ksz.cyclingplanner.template.domain;

import javax.validation.constraints.Max;

/**
 * Value Object
 */
public record WorkoutTemplateName(@Max(value = 500) String value) {

}
