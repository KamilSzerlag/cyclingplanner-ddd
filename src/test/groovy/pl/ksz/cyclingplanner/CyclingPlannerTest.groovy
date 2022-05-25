package pl.ksz.cyclingplanner


import spock.lang.Specification

class CyclingPlannerTest extends Specification {

    def "cyclist can create new cycling training plan"() {
        given: "cyclist provide required parameters for training track, training date"
        when: "cyclist creates new training plan"
        then: "cyclist training's plans view contains new plan"
    }
}
