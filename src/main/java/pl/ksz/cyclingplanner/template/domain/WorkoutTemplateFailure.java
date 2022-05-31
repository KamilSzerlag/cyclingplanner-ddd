package pl.ksz.cyclingplanner.template.domain;


public interface WorkoutTemplateFailure {

    String message();

    record CreatingWorkoutTemplateFailure(String message) implements WorkoutTemplateFailure {

    }

    record FindingWorkoutTemplateFailure(String message) implements  WorkoutTemplateFailure {

    }
}
