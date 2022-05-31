package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;
import pl.ksz.cyclingplanner.template.domain.WorkoutPerformanceParameters;

@Entity
@Table(name = "workout_templates", schema = "workout_templates")
public class WorkoutTemplateEntity extends BaseEntity {

    @Column(name = "value")
    private String name;

    @Type(type = "json")
    @Column(name = "workout_performance_parameters")
    private WorkoutPerformanceParameters expectedWorkoutPerformanceParameters;

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
}
