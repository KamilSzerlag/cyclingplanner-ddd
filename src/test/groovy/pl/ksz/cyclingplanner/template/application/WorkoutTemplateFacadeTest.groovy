package pl.ksz.cyclingplanner.template.application

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.test.context.ActiveProfiles
import pl.ksz.cyclingplanner.WorkoutTemplateNameFixture
import pl.ksz.cyclingplanner.template.domain.Athlete
import pl.ksz.cyclingplanner.template.domain.AthleteId
import spock.lang.Specification

import java.util.stream.Collectors

import static pl.ksz.cyclingplanner.WorkoutPerformanceParametersDTOFixture.anOneHundredsWorkoutPerformanceParameters

@ActiveProfiles("test")
class WorkoutTemplateFacadeTest extends Specification {

    WorkoutTemplateFacade workoutTemplateFacade = new WorkoutTemplateConfiguration().workoutTemplateFacade()

    def "athlete can create workout template"() {
        given:
            stubSecurityContext(UUID.randomUUID())
        and:
            WorkoutTemplateDTO workoutTemplateDTO = new WorkoutTemplateDTO(null, "FTP Builder", anOneHundredsWorkoutPerformanceParameters())
        when:
            def result = workoutTemplateFacade.create(workoutTemplateDTO)
        then:
            result.isSuccess()
        and:
            assert result.getSuccess().uuid().toString() ==~ "^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}"
    }

    def "athlete can find just created workout template"() {
        given:
            stubSecurityContext(UUID.randomUUID())
        and:
            def aSimpleWorkoutTemplateName = WorkoutTemplateNameFixture.aSimpleWorkoutTemplateName()
        and:
            WorkoutTemplateDTO workoutTemplateDTO = new WorkoutTemplateDTO(null, aSimpleWorkoutTemplateName.toString(), anOneHundredsWorkoutPerformanceParameters())
        and:
            def createResult = workoutTemplateFacade.create(workoutTemplateDTO)
        when:
            def findResult = workoutTemplateFacade.findById(createResult.getSuccess().uuid());
        then:
            findResult.isSuccess()
        and:
            verifyAll(findResult) {
                def successValue = findResult.getSuccess()
                successValue.id.uuid() == createResult.getSuccess().uuid()
                successValue.name.value() == workoutTemplateDTO.name()
                successValue.expectedWorkoutPerformanceParameters.avgCadence.value() == 100
            }
    }

    def "athlete can find all created workouts"() {
        given:
            stubSecurityContext(UUID.randomUUID())
        and:
            def workoutTemplatesNames = List.of("workout-1", "workout-2", "workout-3")
        and:
            def workoutTemplateDTOS = workoutTemplatesNames.stream()
                    .map(name -> new WorkoutTemplateDTO(
                            null,
                            name,
                            anOneHundredsWorkoutPerformanceParameters()))
                    .collect(Collectors.toUnmodifiableList())
        when:
        def count = workoutTemplateDTOS.stream()
                .map(dto -> workoutTemplateFacade.create(dto))
                .filter(createResult -> createResult.isSuccess())
                .count()
        and:
            def result = workoutTemplateFacade.findAll()
        then:
            count == 3
        and:
            result.isSuccess()
        and:
            !result.getSuccess().isEmpty()
    }


    def "can create workout templates that belongs to specific athlete"() {
        given:
            stubSecurityContext(UUID.randomUUID())
        and:
            def aSimpleWorkoutTemplateName = WorkoutTemplateNameFixture.aSimpleWorkoutTemplateName()
        and:
            WorkoutTemplateDTO workoutTemplateDTO = new WorkoutTemplateDTO(null, aSimpleWorkoutTemplateName.toString(), anOneHundredsWorkoutPerformanceParameters())
        when:
            def createResult = workoutTemplateFacade.create(workoutTemplateDTO)
        then:
            createResult.isSuccess()
    }


    private void stubSecurityContext(UUID athleteUUID) {
        def context = Stub(SecurityContext)
        SecurityContextHolder.setContext(context);
        def authentication = Stub(Authentication)
        context.getAuthentication() >> authentication
        authentication.getPrincipal() >> new Athlete(new AthleteId(athleteUUID))
    }
}
