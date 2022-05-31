package pl.ksz.cyclingplanner.template.application;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.springframework.lang.Nullable;

public record WorkoutTemplateDTO(@Nullable UUID id, @Min(5) @Max(500)String name, @NotNull WorkoutPerformanceParametersDTO performanceParameters) {

}
