package pl.ksz.cyclingplanner.template.domain;

import io.jenetics.jpx.GPX;
import lombok.Getter;

/**
 * Value Object
 */
@Getter
public final class WorkoutPerformanceParameters implements Comparable<WorkoutPerformanceParameters> {

    private HeartRate avgHeartRate;
    private Cadence avgCadence;
    private Speed avgSpeed;
    private Power avgPower;
    private Distance distance;
    private GPX track;

    private WorkoutPerformanceParameters() {
    }

    private WorkoutPerformanceParameters(HeartRate avgHeartRate, Cadence avgCadence, Speed avgSpeed,
            Power avgPower, Distance distance, GPX track) {
        this.avgHeartRate = avgHeartRate;
        this.avgCadence = avgCadence;
        this.avgSpeed = avgSpeed;
        this.avgPower = avgPower;
        this.distance = distance;
        this.track = track;
    }

    public static WorkoutPerformanceParameters empty() {
        return new WorkoutPerformanceParameters();
    }

    @Override
    public int compareTo(WorkoutPerformanceParameters o) {
        return 0;
    }


    static final class Power implements Achievable, Comparable<Power> {

        private final Integer value;

        Power(Integer value) {
            this.value = value;
        }

        private boolean isAchieved;

        @Override
        public int compareTo(Power o) {
            return value.compareTo(o.value);
        }

        @Override
        public boolean isAchieved() {
            return false;
        }

        public Integer value() {
            return value;
        }
    }

    record Speed(Integer value) implements Achievable, Comparable<Speed> {

        @Override
        public int compareTo(Speed o) {
            return value.compareTo(o.value);
        }

        @Override
        public boolean isAchieved() {
            return false;
        }
    }

    record HeartRate(Integer value) implements Achievable, Comparable<Speed> {

        @Override
        public boolean isAchieved() {
            return false;
        }

        @Override
        public int compareTo(Speed o) {
            return 0;
        }
    }

    record Cadence(Integer value) implements Achievable, Comparable<Speed> {

        @Override
        public int compareTo(Speed o) {
            return 0;
        }

        @Override
        public boolean isAchieved() {
            return false;
        }
    }

    record Distance(Integer value) implements Achievable, Comparable<Speed> {

        @Override
        public int compareTo(Speed o) {
            return 0;
        }

        @Override
        public boolean isAchieved() {
            return false;
        }
    }

    interface Achievable {

        boolean isAchieved();

    }

    public static WorkoutPerformanceParametersBuilder builder() {
        return new WorkoutPerformanceParametersBuilder();
    }


    public static class WorkoutPerformanceParametersBuilder {

        private HeartRate avgHeartRate;
        private Cadence avgCadence;
        private Speed avgSpeed;
        private Power avgPower;
        private Distance distance;
        private GPX track;

        public WorkoutPerformanceParametersBuilder provideExpectedAvgHeartRate(Integer heartRateValue) {
            this.avgHeartRate = new HeartRate(heartRateValue);
            return this;
        }

        public WorkoutPerformanceParametersBuilder provideExpectedAvgCadence(
                Integer cadenceValue) {
            this.avgCadence = new Cadence(cadenceValue);
            return this;
        }

        public WorkoutPerformanceParametersBuilder provideExpectedAvgSpeed(
                Integer speedValue) {
            this.avgSpeed = new Speed(speedValue);
            return this;
        }

        public WorkoutPerformanceParametersBuilder provideExpectedAvgPower(
                Integer avgPower) {
            this.avgPower = new Power(avgPower);
            return this;
        }

        public WorkoutPerformanceParametersBuilder provideExpectedDistance(
                Integer distance) {
            this.distance = new Distance(distance);
            return this;
        }

        public WorkoutPerformanceParametersBuilder provideExpectedTrack(
                GPX gpx) {
            this.track = gpx;
            return this;
        }

        public WorkoutPerformanceParameters build() {
            return new WorkoutPerformanceParameters(avgHeartRate, avgCadence, avgSpeed, avgPower,
                    distance, track);
        }
    }
}
