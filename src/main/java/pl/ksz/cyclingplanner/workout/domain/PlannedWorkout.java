package pl.ksz.cyclingplanner.workout.domain;

import javax.validation.constraints.NotNull;

public record PlannedWorkout(@NotNull WorkoutTemplate workoutTemplate,
                                  @NotNull WorkoutDate workoutDate) {

}

