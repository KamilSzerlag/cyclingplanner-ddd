package pl.ksz.cyclingplanner.template.application;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;
import org.springframework.lang.Nullable;

public record WorkoutTemplateDTO(@Nullable UUID id, @Min(5) @Max(500)String name, @NotNull WorkoutPerformanceParametersDTO performanceParameters) {

}
