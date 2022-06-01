package pl.ksz.cyclingplanner.template.domain;


import java.util.UUID;

public record WorkoutTemplateSnapshot(UUID id, String name,
                               WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {

}
