package pl.ksz.cyclingplanner.template.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pl.ksz.cyclingplanner.workout.domain.WorkoutName;
import pl.ksz.cyclingplanner.workout.domain.WorkoutPerformanceParameters;

/**
 * Entity
 */
@Getter
public class WorkoutTemplate {

    private final pl.ksz.cyclingplanner.workout.domain.Status status = pl.ksz.cyclingplanner.workout.domain.Status.TEMPLATE;

    private final pl.ksz.cyclingplanner.workout.domain.WorkoutName name;

    private final WorkoutPerformanceParameters expectedWorkoutPerformanceParameters;

    public WorkoutTemplate(@Min(5) @Max(500) WorkoutName name,
            @NotNull WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {
        this.name = name;
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
    }
}
