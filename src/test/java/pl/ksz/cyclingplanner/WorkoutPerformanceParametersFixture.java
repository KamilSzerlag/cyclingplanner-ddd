package pl.ksz.cyclingplanner;

import pl.ksz.cyclingplanner.workout.domain.WorkoutPerformanceParameters;

public class WorkoutPerformanceParametersFixture {

    public static WorkoutPerformanceParameters aSimpleWorkoutPerformanceParameters() {
        return WorkoutPerformanceParameters.builder()
                .provideExpectedAvgCadence(90)
                .provideExpectedAvgPower(130).build();
    }


}
