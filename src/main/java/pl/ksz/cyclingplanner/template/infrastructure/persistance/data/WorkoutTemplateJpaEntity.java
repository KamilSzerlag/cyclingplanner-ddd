package pl.ksz.cyclingplanner.template.infrastructure.persistance.data;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import pl.ksz.cyclingplanner.template.domain.WorkoutPerformanceParameters;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateSnapshot;

@Entity
@Table(name = "workout_templates", schema = "workout_template")
public class WorkoutTemplateJpaEntity extends BaseJpaEntity {

    @Column(name = "name")
    private String name;

    @Type(type = "json")
    @Column(name = "workout_performance_parameters")
    private WorkoutPerformanceParameters expectedWorkoutPerformanceParameters;

    @Column(name = "owner_id")
    private UUID ownerId;

    public WorkoutTemplateJpaEntity() {

    }

    public WorkoutTemplateJpaEntity(String name,
            WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {
        this.name = name;
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
    }

    public static WorkoutTemplateJpaEntity of(WorkoutTemplateSnapshot snapshot) {
        return new WorkoutTemplateJpaEntity(snapshot.name(), snapshot.expectedWorkoutPerformanceParameters());
    }

    public WorkoutTemplateSnapshot toSnapshot() {
        return new WorkoutTemplateSnapshot(this.getId(), this.getName(), this.getExpectedWorkoutPerformanceParameters());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutPerformanceParameters getExpectedWorkoutPerformanceParameters() {
        return expectedWorkoutPerformanceParameters;
    }

    public void setExpectedWorkoutPerformanceParameters(
            WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
