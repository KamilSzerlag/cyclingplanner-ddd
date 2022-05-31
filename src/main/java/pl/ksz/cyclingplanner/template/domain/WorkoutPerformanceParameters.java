package pl.ksz.cyclingplanner.template.domain;

import io.jenetics.jpx.GPX;
import liquibase.pro.packaged.P;
import lombok.Getter;
import pl.ksz.cyclingplanner.template.application.WorkoutPerformanceParametersDTO;
import pl.ksz.cyclingplanner.template.application.WorkoutTemplateDTO;

/**
 * Value Object
 */
@Getter
public final class WorkoutPerformanceParameters {

    private HeartRate avgHeartRate;
    private Cadence avgCadence;
    private Speed avgSpeed;
    private Power avgPower;
    private Distance distance;

    private WorkoutPerformanceParameters() {
    }

    private WorkoutPerformanceParameters(HeartRate avgHeartRate, Cadence avgCadence, Speed avgSpeed,
            Power avgPower, Distance distance) {
        this.avgHeartRate = avgHeartRate;
        this.avgCadence = avgCadence;
        this.avgSpeed = avgSpeed;
        this.avgPower = avgPower;
        this.distance = distance;
    }

    public static WorkoutPerformanceParameters empty() {
        return new WorkoutPerformanceParameters();
    }

    public static WorkoutPerformanceParameters of(WorkoutPerformanceParametersDTO dto) {
        return new WorkoutPerformanceParameters(new HeartRate(dto.avgHeartRate()),
                new Cadence(dto.avgCadence()),
                new Speed(dto.avgSpeed()),
                new Power(dto.avgPower()),
                new Distance(dto.distance()));
    }

    record Power(Integer value) {

    }

    record Speed(Integer value) {

    }

    record HeartRate(Integer value) {

    }

    record Cadence(Integer value) {

    }

    record Distance(Integer value) {

    }

}
