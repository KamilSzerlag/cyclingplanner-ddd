package pl.ksz.cyclingplanner.workout.domain


import pl.ksz.cyclingplanner.workout.domain.Workout
import spock.lang.Specification

import static pl.ksz.cyclingplanner.WorkoutNameFixture.aRandomWorkoutName
import static pl.ksz.cyclingplanner.WorkoutPerformanceParametersFixture.*
import static pl.ksz.cyclingplanner.workout.domain.Workout.createNewWorkoutTemplate

class WorkoutTest extends Specification {

//    @Subject
//    Workout workout = new Workout()


    def "should create new workout template"() {
        when: "athlete creates new workout"
            def workoutTemplateCreationResult = createNewWorkoutTemplate(aRandomWorkoutName(), aSimpleWorkoutPerformanceParameters())
        then: "workout template exists"
            workoutTemplateCreationResult.success
        expect:
            workoutTemplateCreationResult.isSuccess()
    }

    def "should not create workout template without name"() {
        when: "athlete creates new workout without value"
            def workoutTemplateCreationResult = createNewWorkoutTemplate(null, aSimpleWorkoutPerformanceParameters())
        then: "workout template not created"
            workoutTemplateCreationResult.failure
        expect:
            workoutTemplateCreationResult.isFailure();
    }

    def "should not create workout template without performance parameters"() {
        when: "athlete creates new workout without value"
            def workoutTemplateCreationResult = createNewWorkoutTemplate(aRandomWorkoutName(), null)
        then: "workout template not created"
            workoutTemplateCreationResult.failure
        expect:
            workoutTemplateCreationResult.isFailure();
    }

    def "should not create workout that exceed athlete abilities"() {
//        when: "athlete creates new workout without value"
//            def workoutTemplateCreationResult = createNewWorkoutTemplate(aRandomWorkoutName(), null)
//        then: "workout template not created"
//            workoutTemplateCreationResult.failure
//        expect:
//            workoutTemplateCreationResult.isFailure();
    }



    def "should mark cycling training plan as done"() {
        given: "cyclist has created training plan"
            Workout training = Stub(Workout)
        and: "training plan is created, so current status is planned "
            training.isPlannedTraining();
        when:
            training.markCyclingTrainingPlanAsDone();
        then:
            training.isDoneTraining();
    }

//    def "should not mark cycling training plan as done if training is cancelled"() {
//        given: "cyclist has created training plan"
//            CyclingTrainingPlan cyclingTrainingPlan = new CyclingTrainingPlan()
//        and:
//        when: ""
//        this.cyclingTrainingPlan.markCyclingTrainingPlanAsDone()
//
//        expect:
//        this.cyclingTrainingPlan.trainingStatus == TrainingStatus.CANCELLED
//    }
//
//    def "should mark cycling training plan as cancelled"() {
//        given:
//        this.cyclingTrainingPlan.trainingStatus == TrainingStatus.PLANNED
//
//        when:
//        this.cyclingTrainingPlan.markCyclingTrainingPlanAsCancelled()
//
//        expect:
//        this.cyclingTrainingPlan.trainingStatus == TrainingStatus.CANCELLED
//    }
//
//
//    def "should not mark cycling training plan as cancelled if training plan is done"() {
//        given:
//        this.cyclingTrainingPlan.trainingStatus == TrainingStatus.DONE
//
//        when:
//        this.cyclingTrainingPlan.markCyclingTrainingPlanAsCancelled();
//
//        expect:
//        this.cyclingTrainingPlan.trainingStatus == TrainingStatus.DONE
//    }
//
//    def "should change cycling training date"() {
//    }
//
//    def "should change cycling training plan parameters"() {
//    }
}
