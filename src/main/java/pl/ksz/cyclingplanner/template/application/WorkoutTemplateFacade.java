package pl.ksz.cyclingplanner.template.application;

import java.util.List;
import java.util.UUID;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.CreatingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.FindingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.util.ModuleAPI;
import pl.ksz.cyclingplanner.util.Result;

@ModuleAPI
public class WorkoutTemplateFacade {

    private final WorkoutTemplateService workoutTemplateService;

    public WorkoutTemplateFacade(final WorkoutTemplateService workoutTemplateService) {
        this.workoutTemplateService = workoutTemplateService;
    }

    public Result<CreatingWorkoutTemplateFailure, WorkoutTemplateId> create(
            WorkoutTemplateDTO templateDTO) {
        return workoutTemplateService
                .createWorkoutTemplate()
                .apply(templateDTO);
    }

    public Result<FindingWorkoutTemplateFailure, WorkoutTemplate> findById(UUID id) {
        return workoutTemplateService.findById()
                .apply(id);
    }

    public Result<FindingWorkoutTemplateFailure, List<WorkoutTemplate>> findAll() {
        return workoutTemplateService.findAll()
                .get();
    }
}
