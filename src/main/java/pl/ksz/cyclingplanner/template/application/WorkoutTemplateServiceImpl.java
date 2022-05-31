package pl.ksz.cyclingplanner.template.application;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.ksz.cyclingplanner.template.domain.Athlete;
import pl.ksz.cyclingplanner.template.domain.AthleteId;
import pl.ksz.cyclingplanner.template.domain.WorkoutRepository;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplate;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.CreatingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.FindingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.util.Result;
import pl.ksz.cyclingplanner.util.Result.Success;


@Service
class WorkoutTemplateServiceImpl implements WorkoutTemplateService {

    private final WorkoutTemplateMapper workoutTemplateMapper;
    private final WorkoutRepository workoutRepository;

    public WorkoutTemplateServiceImpl(WorkoutTemplateMapper workoutTemplateMapper,
            WorkoutRepository workoutRepository) {
        this.workoutTemplateMapper = workoutTemplateMapper;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Function<WorkoutTemplateDTO, Result<CreatingWorkoutTemplateFailure, WorkoutTemplateId>> createWorkoutTemplate() {
        return workoutTemplateMapper
                .mapDTO()
                .andThen(this::provideTemplateCreator)
                .andThen(workoutRepository::save)
                .andThen(WorkoutTemplate::getId)
                .andThen(Success::new);
    }

    @Override
    public Function<UUID, Result<FindingWorkoutTemplateFailure, WorkoutTemplate>> findById() {
        return id -> {
            Optional<WorkoutTemplate> byId = workoutRepository.findById(new WorkoutTemplateId(id));
            if (byId.isPresent()) {
                return Result.success(byId.get());
            }
            return Result.failure(new FindingWorkoutTemplateFailure(""));
        };
    }

    @Override
    public Supplier<Result<FindingWorkoutTemplateFailure, List<WorkoutTemplate>>> findAll() {
        return () -> Result.success(workoutRepository.findAllByAthleteId(
                requireNonNull(getPrincipal()).id()));
    }

    private WorkoutTemplate provideTemplateCreator(WorkoutTemplate workoutTemplate) {
        return provideTemplateCreator()
                .apply(workoutTemplate)
                .apply(getPrincipal());
    }

    private AthleteId getPrincipal() {
        if (SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal() instanceof Athlete athlete) {
            return athlete.id();
        }
        return null;
    }

    private Function<WorkoutTemplate, Function<AthleteId, WorkoutTemplate>> provideTemplateCreator() {
        return workoutTemplate -> workoutTemplate::withTemplateCreator;
    }
}
