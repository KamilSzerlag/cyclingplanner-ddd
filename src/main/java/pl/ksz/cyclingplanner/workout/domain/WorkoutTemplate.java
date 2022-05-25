package pl.ksz.cyclingplanner.workout.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Entity
 */
@Getter
public class WorkoutTemplate {

    private final Status status = Status.TEMPLATE;

    private final WorkoutName name;

    private final WorkoutPerformanceParameters expectedWorkoutPerformanceParameters;

    public WorkoutTemplate(@Min(5) @Max(500) WorkoutName name,
            @NotNull WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {
        this.name = name;
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
    }
}
