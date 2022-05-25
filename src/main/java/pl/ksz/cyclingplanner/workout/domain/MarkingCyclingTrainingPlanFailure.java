package pl.ksz.cyclingplanner.workout.domain;

import pl.ksz.cyclingplanner.workout.domain.MarkingCyclingTrainingPlanFailure.InappropriateCyclingTrainingStatusTarget;

sealed interface MarkingCyclingTrainingPlanFailure permits
        InappropriateCyclingTrainingStatusTarget {

    record InappropriateCyclingTrainingStatusTarget() implements MarkingCyclingTrainingPlanFailure {
    }



}
