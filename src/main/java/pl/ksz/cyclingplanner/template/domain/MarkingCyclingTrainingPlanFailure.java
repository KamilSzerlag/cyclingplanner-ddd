package pl.ksz.cyclingplanner.template.domain;

import pl.ksz.cyclingplanner.workout.domain.MarkingCyclingTrainingPlanFailure.InappropriateCyclingTrainingStatusTarget;

sealed interface MarkingCyclingTrainingPlanFailure permits
        InappropriateCyclingTrainingStatusTarget {

    record InappropriateCyclingTrainingStatusTarget() implements MarkingCyclingTrainingPlanFailure {
    }



}
