package hello.groovy

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

import javax.inject.*

// needed to get the Singleton from there, otherwise the one from Groovy wins

interface Engine {
    Integer getCylinders()
    String start()
}

@Singleton
class CrankShaft {}

class V8Engine implements Engine {
    Integer cylinders = 8
    final CrankShaft crankShaft
    V8Engine(CrankShaft crankShaft) {
        this.crankShaft = crankShaft
    }
    String start() { "Starting V8 with ${crankShaft}" }
}

@Factory
class EngineFactory {
    @Bean
    @Singleton
    Engine v8Engine(CrankShaft crankShaft) {
        new V8Engine(crankShaft)
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