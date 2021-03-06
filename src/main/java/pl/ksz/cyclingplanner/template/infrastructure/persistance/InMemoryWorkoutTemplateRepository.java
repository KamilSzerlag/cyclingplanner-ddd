package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import static pl.ksz.cyclingplanner.util.ProfilesConst.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateRepository;
import pl.ksz.cyclingplanner.util.ProfilesConst;

@Repository
@Profile(TEST_PROFILE)
public class InMemoryWorkoutTemplateRepository implements WorkoutTemplateRepository {

    private final Map<UUID, WorkoutTemplate> workoutTemplateStorage = new HashMap<>();

    @Override
    public WorkoutTemplate save(WorkoutTemplate entity) {
        workoutTemplateStorage.put(entity.getId().uuid(), entity);
        return entity;
    }

    @Override
    public Optional<WorkoutTemplate> findById(WorkoutTemplateId id) {
        return Optional.ofNullable(workoutTemplateStorage.get(id.uuid()));
    }

    @Override
    public List<WorkoutTemplate> findAll() {
        return workoutTemplateStorage.values()
                .stream()
                .toList();
    }

    @Override
    public List<WorkoutTemplate> findAllByAthleteId(UUID athleteId) {
        return workoutTemplateStorage.values().stream()
                .filter(workoutTemplate -> workoutTemplate.getCreatorId().id().equals(athleteId))
                .toList();
    }

    @Override
    public WorkoutTemplate update(WorkoutTemplate workoutTemplate) {
        return workoutTemplateStorage.replace(workoutTemplate.getId().uuid(), workoutTemplate);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(WorkoutTemplateId id) {

    }
}
