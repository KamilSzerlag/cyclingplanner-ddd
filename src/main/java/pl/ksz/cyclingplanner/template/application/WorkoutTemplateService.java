package pl.ksz.cyclingplanner.template.application;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.CreatingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.FindingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.util.Result;

interface WorkoutTemplateService {

    Function<WorkoutTemplateDTO, Result<CreatingWorkoutTemplateFailure, WorkoutTemplateId>> createWorkoutTemplate();

    Function<UUID, Result<FindingWorkoutTemplateFailure, WorkoutTemplate>> findById();

    Supplier<Result<FindingWorkoutTemplateFailure, List<WorkoutTemplate>>> findAll();
}
