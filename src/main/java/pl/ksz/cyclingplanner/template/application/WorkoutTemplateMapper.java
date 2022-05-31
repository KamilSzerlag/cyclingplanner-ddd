package pl.ksz.cyclingplanner.template.application;

import java.util.function.Function;
import org.springframework.stereotype.Component;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateName;
import pl.ksz.cyclingplanner.template.domain.WorkoutPerformanceParameters;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateDomainService;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;

@Component
public class WorkoutTemplateMapper {

    Function<WorkoutTemplateDTO, WorkoutTemplate> mapDTO() {
        return this::map;
    }

    private WorkoutTemplate map(final WorkoutTemplateDTO dto) {
        if (dto.performanceParameters() == null) {
            return workoutTemplateFrom(dto, WorkoutPerformanceParameters.empty());
        }
        return workoutTemplateFrom(dto,
                WorkoutPerformanceParameters.of(dto.performanceParameters()));
    }

    private WorkoutTemplate workoutTemplateFrom(WorkoutTemplateDTO templateDTO,
            WorkoutPerformanceParameters performanceParameters) {
        return new WorkoutTemplate(
                provideTemplateId(templateDTO),
                new WorkoutTemplateName(templateDTO.name()),
                performanceParameters);
    }

    private WorkoutTemplateId provideTemplateId(final WorkoutTemplateDTO dto) {
        return dto.id() == null ? WorkoutTemplateDomainService.generateWorkoutTemplateId()
                : new WorkoutTemplateId(dto.id());
    }

}
