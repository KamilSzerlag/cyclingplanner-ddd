package pl.ksz.cyclingplanner

import pl.ksz.cyclingplanner.Polygon
import pl.ksz.cyclingplanner.TooFewSidesException
import spock.lang.Specification

class CyclingPlannerTest extends Specification {

    def "cyclist can create new cycling training plan"() {
        given: "cyclist provide required parameters for training track, training date"
        when: "cyclist creates new training plan"
        then: "cyclist training's plans view contains new plan"
    }





//    Spock Tests Examples:
    def "should be a simple test assertion"() {
        expect:
        1 == 1
    }

//    You can read a given/when/then test like this:
//
//    given that I have a Polygon with four sides,
//    when we get the number of sides
//    then that number of sides should be equal to four
    def "should demonstrate given-when-then"() {
        given:
        def polygon = new Polygon(4)

        when:
        int sides = polygon.numberOfSides

        then:
        sides == 4
    }

    def "should expect Exceptions"() {
        when:
        new Polygon(0)

        then:
        thrown(TooFewSidesException)
    }
}
