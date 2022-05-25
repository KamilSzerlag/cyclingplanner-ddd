package pl.ksz.cyclingplanner.workout.domain;

import jakarta.validation.constraints.NotNull;

public record PlannedWorkout(@NotNull WorkoutTemplate workoutTemplate,
                                  @NotNull WorkoutDate workoutDate) {

}

