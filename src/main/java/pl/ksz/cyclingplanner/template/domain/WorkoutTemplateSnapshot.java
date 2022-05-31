package pl.ksz.cyclingplanner.template.domain;


import java.util.UUID;

record WorkoutTemplateSnapshot(UUID id, String name,
                               WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {

}
