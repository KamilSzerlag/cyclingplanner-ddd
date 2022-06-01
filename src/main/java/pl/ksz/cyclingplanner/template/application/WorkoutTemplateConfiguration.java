package pl.ksz.cyclingplanner.template.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.ksz.cyclingplanner.template.infrastructure.persistance.InMemoryWorkoutTemplateRepository;
import pl.ksz.cyclingplanner.template.infrastructure.persistance.JpaWorkoutTemplateRepositoryImpl;

@Configuration
public class WorkoutTemplateConfiguration {

    public WorkoutTemplateFacade workoutTemplateFacade() {
        return new WorkoutTemplateFacade(new WorkoutTemplateServiceImpl(new WorkoutTemplateMapper(), new InMemoryWorkoutTemplateRepository()));
    }

    @Bean
    public WorkoutTemplateFacade workoutTemplateFacade(WorkoutTemplateService workoutTemplateService) {
        return new WorkoutTemplateFacade(workoutTemplateService);
    }

}
