package hello.groovy

import javax.inject.* // needed to get the Singleton from there, otherwise the one from Groovy wins

interface Engine {
    Integer getCylinders()
    String start()
}

@Singleton
class V8Engine implements Engine {
    Integer cylinders = 8
    String start() { "Starting V8" }
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