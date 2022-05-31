package pl.ksz.cyclingplanner.template.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.ksz.cyclingplanner.template.infrastructure.persistance.InMemoryWorkoutRepository;

@Configuration
public class WorkoutTemplateConfiguration {

    @Bean
    @Profile("test")
    public WorkoutTemplateFacade workoutTemplateFacade() {
        return new WorkoutTemplateFacade(new WorkoutTemplateServiceImpl(new WorkoutTemplateMapper(), new InMemoryWorkoutRepository()));
    }

    @Bean
    @Profile("prod")
    public WorkoutTemplateFacade workoutTemplateFacade(WorkoutTemplateService workoutTemplateService) {
        return new WorkoutTemplateFacade(workoutTemplateService);
    }

}
