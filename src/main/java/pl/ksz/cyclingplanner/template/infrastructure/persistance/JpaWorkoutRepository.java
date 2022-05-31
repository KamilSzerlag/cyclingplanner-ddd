package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import pl.ksz.cyclingplanner.template.domain.WorkoutRepository;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;

//@Repository
//public class JpaWorkoutRepository implements WorkoutRepository {
//
//    @Override
//    public WorkoutTemplate save(WorkoutTemplate entity) {
//        return null;
//    }
//
//    @Override
//    public Optional<WorkoutTemplate> findById(WorkoutTemplateId id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Iterable<WorkoutTemplate> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<WorkoutTemplate> findAllByAthleteId(UUID AthleteId) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(WorkoutTemplateId id) {
//
//    }
//}
