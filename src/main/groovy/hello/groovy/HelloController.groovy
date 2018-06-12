package hello.groovy

import io.micronaut.http.annotation.*

@Controller("/hello")
class HelloController {
	@Get("/")
	String index() {
		"Hello, World!"
	}
}
