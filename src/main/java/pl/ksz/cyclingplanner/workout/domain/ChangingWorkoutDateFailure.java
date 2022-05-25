package pl.ksz.cyclingplanner.workout.domain;

import pl.ksz.cyclingplanner.workout.domain.ChangingWorkoutDateFailure.IncorrectWorkoutStatusForMakingChange;
import pl.ksz.cyclingplanner.workout.domain.ChangingWorkoutDateFailure.WorkoutDateMustBeAFutureDate;

public sealed interface ChangingWorkoutDateFailure permits
        WorkoutDateMustBeAFutureDate, IncorrectWorkoutStatusForMakingChange {

    record WorkoutDateMustBeAFutureDate() implements ChangingWorkoutDateFailure {

    }

    record IncorrectWorkoutStatusForMakingChange() implements ChangingWorkoutDateFailure {

    }
}
