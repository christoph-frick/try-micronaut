package hello.groovy

import javax.inject.*
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

// needed to get the Singleton from there, otherwise the one from Groovy wins

interface Engine {
    Integer getCylinders()
    String start()
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface V8 {}

@Singleton
class V6Engine implements Engine {
    Integer cylinders = 6
    String start() { "Starting V6" }
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
    Vehicle(@V8 Engine engine) {
        this.engine = engine
    }

    String start() { engine.start() }

}