package pl.ksz.cyclingplanner.workout.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
