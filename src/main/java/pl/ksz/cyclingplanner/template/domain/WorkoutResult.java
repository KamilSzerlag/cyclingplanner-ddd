package pl.ksz.cyclingplanner.template.domain;

/**
 * Value Object
 */
public class WorkoutResult {

    private WorkoutResult(TrainingResultStatus value) {
        this.value = value;
    }

    enum TrainingResultStatus{
        SUCCESS,
        PARTIAL_SUCCESS,
        FAILED,
        UNKNOWN;
    }

    private TrainingResultStatus value;

    static WorkoutResult success() {
        return new WorkoutResult(TrainingResultStatus.SUCCESS);
    }

    static WorkoutResult fail() {
        return new WorkoutResult(TrainingResultStatus.FAILED);
    }

    static WorkoutResult unknown() {
        return new WorkoutResult(TrainingResultStatus.UNKNOWN);
    }
}
