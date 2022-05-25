package pl.ksz.cyclingplanner.workout.domain;

import java.time.LocalDateTime;

/**
 * Value Object
 */
public final class WorkoutDate {

    private WorkoutDate(LocalDateTime trainingDate) {
        this.trainingDate = trainingDate;
    }

    private final LocalDateTime trainingDate;

    public static WorkoutDate createTrainingDate(LocalDateTime futureDate) {

        if (futureDate.isAfter(LocalDateTime.now())) {
            return new WorkoutDate(futureDate);
        }

        throw new IllegalArgumentException("Training date must be in future date!");
    }

    public LocalDateTime asDate() {
        return trainingDate;
    }
}
