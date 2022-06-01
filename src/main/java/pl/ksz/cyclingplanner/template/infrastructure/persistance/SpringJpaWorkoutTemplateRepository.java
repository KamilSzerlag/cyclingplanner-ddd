package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.ksz.cyclingplanner.template.infrastructure.persistance.data.WorkoutTemplateJpaEntity;

public interface SpringJpaWorkoutTemplateRepository extends
        JpaRepository<WorkoutTemplateJpaEntity, UUID> {

    List<WorkoutTemplateJpaEntity> findByOwnerIdIs(UUID ownerId);

    Slice<WorkoutTemplateJpaEntity> findByOwnerIdIs(UUID ownerId, Pageable pageable);

}
