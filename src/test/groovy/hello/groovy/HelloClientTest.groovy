package hello.groovy

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloClientTest extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared HelloClient client = embeddedServer.applicationContext.getBean(HelloClient)

    def "test hello client"() {
        expect:
        client.hello().blockingGet() == 'Hello, World!'
    }
}
