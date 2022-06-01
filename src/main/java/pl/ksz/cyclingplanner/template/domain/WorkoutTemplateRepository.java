package pl.ksz.cyclingplanner.template.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutTemplateRepository {

    WorkoutTemplate save(WorkoutTemplate workoutTemplateSnapshot);

    Optional<WorkoutTemplate> findById(WorkoutTemplateId id);

//    boolean existsById(ID id);

    List<WorkoutTemplate> findAll();

    List<WorkoutTemplate> findAllByAthleteId(UUID AthleteId);

    WorkoutTemplate update(WorkoutTemplate workoutTemplate);

    long count();

    void deleteById(WorkoutTemplateId id);

}
