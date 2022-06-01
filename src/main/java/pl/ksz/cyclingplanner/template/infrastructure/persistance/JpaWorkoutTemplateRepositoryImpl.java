package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateRepository;
import pl.ksz.cyclingplanner.template.infrastructure.persistance.data.WorkoutTemplateJpaEntity;

@Repository
public class JpaWorkoutTemplateRepositoryImpl implements WorkoutTemplateRepository {

    private final SpringJpaWorkoutTemplateRepository springJpaWorkoutTemplateRepository;

    public JpaWorkoutTemplateRepositoryImpl(
            SpringJpaWorkoutTemplateRepository springJpaWorkoutTemplateRepository) {
        this.springJpaWorkoutTemplateRepository = springJpaWorkoutTemplateRepository;
    }

    @Override
    public WorkoutTemplate save(final WorkoutTemplate workoutTemplate) {
        final WorkoutTemplateJpaEntity databaseEntity = WorkoutTemplateJpaEntity.of(
                workoutTemplate.toSnapshot());
        final WorkoutTemplateJpaEntity savedDatabaseEntity = springJpaWorkoutTemplateRepository.save(
                databaseEntity);
        return WorkoutTemplate.fromSnapshot(savedDatabaseEntity.toSnapshot());
    }

    @Override
    public Optional<WorkoutTemplate> findById(WorkoutTemplateId id) {
        return springJpaWorkoutTemplateRepository.findById(id.uuid())
                .map(workoutTemplateJpaEntity ->
                        WorkoutTemplate.fromSnapshot(workoutTemplateJpaEntity.toSnapshot()));
    }

    @Override
    public List<WorkoutTemplate> findAll() {
        return springJpaWorkoutTemplateRepository.findAll().stream()
                .map(workoutTemplateJpaEntity -> WorkoutTemplate.fromSnapshot(
                        workoutTemplateJpaEntity.toSnapshot())).toList();

    }

    @Override
    public List<WorkoutTemplate> findAllByAthleteId(UUID athleteId) {
        return springJpaWorkoutTemplateRepository.findByOwnerIdIs(athleteId).stream()
                .map(workoutTemplateJpaEntity -> WorkoutTemplate.fromSnapshot(
                        workoutTemplateJpaEntity.toSnapshot())).toList();

    }

    @Override
    public WorkoutTemplate update(final WorkoutTemplate workoutTemplate) {
        return save(workoutTemplate);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(WorkoutTemplateId id) {

    }
}
