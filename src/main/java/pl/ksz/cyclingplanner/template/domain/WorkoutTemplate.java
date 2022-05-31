package pl.ksz.cyclingplanner.template.domain;

import java.util.Objects;
import pl.ksz.cyclingplanner.util.DomainEntity;

/**
 * Entity
 */
@DomainEntity
public final class WorkoutTemplate {

    private WorkoutTemplateId id;
    private WorkoutTemplateName name;
    private WorkoutPerformanceParameters expectedWorkoutPerformanceParameters;

    private AthleteId creatorId;

    public WorkoutTemplate() {
    }

    public WorkoutTemplate(WorkoutTemplateId id, WorkoutTemplateName name,
            WorkoutPerformanceParameters expectedWorkoutPerformanceParameters) {
        this.id = id;
        this.name = name;
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
    }

    public WorkoutTemplate(WorkoutTemplateId id, WorkoutTemplateName name,
            WorkoutPerformanceParameters expectedWorkoutPerformanceParameters,
            AthleteId templateCreatorId) {
        this.id = id;
        this.name = name;
        this.expectedWorkoutPerformanceParameters = expectedWorkoutPerformanceParameters;
        this.creatorId = templateCreatorId;
    }

    public WorkoutTemplate withTemplateCreator(AthleteId creatorId) {
        if (Objects.nonNull(creatorId)) {
            return new WorkoutTemplate(this.id, this.name,
                    this.expectedWorkoutPerformanceParameters, creatorId);
        }
        throw new IllegalStateException();
    }

    public WorkoutTemplateId getId() {
        return id;
    }

    public WorkoutTemplateName getName() {
        return name;
    }

    public WorkoutPerformanceParameters getExpectedWorkoutPerformanceParameters() {
        return expectedWorkoutPerformanceParameters;
    }

    public AthleteId getCreatorId() {
        return creatorId;
    }

    public WorkoutTemplateSnapshot toSnapshot() {
        return new WorkoutTemplateSnapshot(this.id.uuid(), this.name.value(),
                this.expectedWorkoutPerformanceParameters);
    }

    public WorkoutTemplate fromSnapshot(WorkoutTemplateSnapshot snapshot) {
        return new WorkoutTemplate(new WorkoutTemplateId(snapshot.id()),
                new WorkoutTemplateName(snapshot.name()),
                snapshot.expectedWorkoutPerformanceParameters());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (WorkoutTemplate) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.expectedWorkoutPerformanceParameters,
                        that.expectedWorkoutPerformanceParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expectedWorkoutPerformanceParameters);
    }

    @Override
    public String toString() {
        return "WorkoutTemplate[" +
                "value=" + name + ", " +
                "expectedWorkoutPerformanceParameters=" + expectedWorkoutPerformanceParameters
                + ']';
    }


}
