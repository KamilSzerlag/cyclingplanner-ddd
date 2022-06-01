package pl.ksz.cyclingplanner.workout.domain;

import javax.validation.constraints.Max;

/**
 * Value Object
 */
public record WorkoutName(@Max(value = 500) String name) {

}
