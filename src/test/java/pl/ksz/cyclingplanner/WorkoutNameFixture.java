package pl.ksz.cyclingplanner;

import com.github.javafaker.Faker;
import pl.ksz.cyclingplanner.workout.domain.WorkoutName;

public class WorkoutNameFixture {


    public static WorkoutName aRandomWorkoutName() {
        return new WorkoutName(new Faker().commerce().productName());
    }
}
