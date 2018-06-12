package hello.groovy

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class HelloControllerTest extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared @AutoCleanup HttpClient client = HttpClient.create(embeddedServer.URL)

    def "test hello world response"() {
        expect:
        client.toBlocking().retrieve(HttpRequest.GET('/hello')) == "Hello, World!"
    }

}
