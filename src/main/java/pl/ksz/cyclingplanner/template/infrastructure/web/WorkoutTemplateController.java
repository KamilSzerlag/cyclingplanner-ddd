package pl.ksz.cyclingplanner.template.infrastructure.web;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import pl.ksz.cyclingplanner.template.application.WorkoutTemplateDTO;
import pl.ksz.cyclingplanner.template.application.WorkoutTemplateFacade;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateFailure.CreatingWorkoutTemplateFailure;
import pl.ksz.cyclingplanner.template.domain.WorkoutTemplateId;
import pl.ksz.cyclingplanner.util.Result;

@RestController(WorkoutTemplateController.TEMPLATES_ENDPOINT)
public class WorkoutTemplateController {

    public static final String TEMPLATES_ENDPOINT = "/templates";
    private final WorkoutTemplateFacade workoutTemplateFacade;

    public WorkoutTemplateController(WorkoutTemplateFacade workoutTemplateFacade) {
        this.workoutTemplateFacade = workoutTemplateFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createWorkoutTemplate(UriComponentsBuilder ucb,
            @Validated @RequestBody final WorkoutTemplateDTO dto) {
        Result<CreatingWorkoutTemplateFailure, WorkoutTemplateId> result = workoutTemplateFacade.create(
                dto);
        if (result.isSuccess()) {
            WorkoutTemplateId id = result.getSuccess();
            return ResponseEntity.created(getCreatedResourceLocation(ucb, id.uuid().toString()))
                    .build();
        }
        if (result.isFailure()) {
            return ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
                    .withDetail(result.getFailure().message())
                    .withInstance(ucb.build().toUri())).build();
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .build();
    }

    private URI getCreatedResourceLocation(UriComponentsBuilder ucb,
            final String resourceId) {
        return ucb.path(TEMPLATES_ENDPOINT).path(resourceId).build()
                .toUri();
    }

}
