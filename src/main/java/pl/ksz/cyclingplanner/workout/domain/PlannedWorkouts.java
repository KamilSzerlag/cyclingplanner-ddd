package pl.ksz.cyclingplanner.workout.domain;

import java.util.List;

public record PlannedWorkouts(List<PlannedWorkout> plannedWorkouts) {

    public PlannedWorkouts(List<PlannedWorkout> plannedWorkouts) {
        this.plannedWorkouts = List.copyOf(plannedWorkouts);
    }

}
