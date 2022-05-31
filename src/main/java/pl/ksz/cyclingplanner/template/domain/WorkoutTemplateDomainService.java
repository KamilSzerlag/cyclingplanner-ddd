package pl.ksz.cyclingplanner.template.domain;

import java.util.UUID;

public class WorkoutTemplateDomainService {

    public static WorkoutTemplateId generateWorkoutTemplateId() {
        return new WorkoutTemplateId(UUID.randomUUID());
    }

}
