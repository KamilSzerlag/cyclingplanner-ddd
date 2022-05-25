package pl.ksz.cyclingplanner.template.domain;

import jakarta.validation.constraints.Max;

/**
 * Value Object
 */
public record WorkoutName(@Max(value = 500) String name) {

}
