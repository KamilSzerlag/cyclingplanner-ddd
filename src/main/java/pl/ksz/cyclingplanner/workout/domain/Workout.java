package pl.ksz.cyclingplanner.workout.domain;

import java.time.LocalDateTime;
import pl.ksz.cyclingplanner.workout.domain.MarkingCyclingTrainingPlanFailure.InappropriateCyclingTrainingStatusTarget;
import pl.ksz.cyclingplanner.workout.domain.Result.Failure;
import pl.ksz.cyclingplanner.workout.domain.Result.Success;

/**
 * Aggregate
 */
public final class Workout {

//    workoutTemplate
//    status;
//    athleteId;
//    plannedWorkouts;
//    doneWorkouts;



    public static Result<CreatingWorkoutFailure, WorkoutTemplate> createNewWorkoutTemplate(WorkoutName workoutName, WorkoutPerformanceParameters expectedPerformanceParameters) {
        if (workoutName != null && expectedPerformanceParameters != null) {
            return new Success<>(new WorkoutTemplate(workoutName, expectedPerformanceParameters));
        }
        return new Failure<>(new CreatingWorkoutFailure());
    }

    public static Result<PlanningWorkoutFailure, PlannedWorkout> planWorkout(WorkoutTemplate workoutTemplate, WorkoutDate workoutDate) {
        if (workoutTemplate == null && workoutDate == null) {
            return new Failure<>(new PlanningWorkoutFailure());
        }
        if (workoutDate.asDate().isBefore(LocalDateTime.now())) {
            return new Failure<>(new PlanningWorkoutFailure());
        }
        return new Success<>(new PlannedWorkout(workoutTemplate, workoutDate));
    }

    public static Result<MarkingCyclingTrainingPlanFailure, Workout> markCyclingTrainingPlanAsDone(PlannedWorkout plannedWorkout, WorkoutPerformanceParameters achievedPerformanceParameters) {
//            //compare  Training Parameters
//            this.result = resolveTrainingResult();
//            return new Success<>(new Workout());
//        }

        return new Failure<>(new InappropriateCyclingTrainingStatusTarget());
    }

    Result<MarkingCyclingTrainingPlanFailure, Workout> markCyclingTrainingPlanAsCancelled() {
//        if (isPlannedTraining()) {
//            this.status = Status.CANCELLED;
//            //Return Result Success
//            return new Success<>(new Workout());
//        }
        //Return Result Failed
        return new Failure<>(new InappropriateCyclingTrainingStatusTarget());
    }


    Result<ChangingWorkoutDateFailure, Workout> changeCyclingTrainingPlanDate() {
        return Result.success(new Workout());
    }

    Result<IllegalStateException, Workout> changeCyclingTrainingPlanParameters() {
        return Result.success(new Workout());
    }



    private WorkoutResult resolveTrainingResult() {
//        if (achievedWorkoutPerformanceParameters.compareTo(expectedWorkoutPerformanceParameters) >= 0) {
//            return TrainingResult.success();
//        }
        return WorkoutResult.fail();
    }

    public boolean isPlannedTraining() {
//        return Status.PLANNED.equals(status);
        return false;
    }

    public boolean isDoneTraining() {
//        return Status.DONE.equals(status);
        return false;
    }

    public boolean isCancelled() {
//        return Status.CANCELLED.equals(status);
        return false;
    }

}
