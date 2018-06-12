package hello.groovy

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

import javax.annotation.PostConstruct
import javax.inject.*

// needed to get the Singleton from there, otherwise the one from Groovy wins

interface Engine {
    Integer getCylinders()
    String start()
}

@Singleton
class V8Engine implements Engine {
    Integer cylinders = 8
    private Boolean init = false

    String start() {
        assert init
        "Starting V8"
    }

    @PostConstruct
    void initialize() {
        this.init = true
    }
}

@Singleton
class Vehicle {

    // does not work: results in errors with dep injection // @Delegate
    final Engine engine

    @Inject
    Vehicle(Engine engine) {
        this.engine = engine
    }

    String start() { engine.start() }

}