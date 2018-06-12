package hello.groovy

import groovy.util.logging.Slf4j
import io.micronaut.context.BeanContext
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
@Slf4j
class Application {
    static void main(String[] args) {
        def v = BeanContext.run().getBean(Vehicle)
        log.info(v.start())
        Micronaut.run(Application.class)
    }
}