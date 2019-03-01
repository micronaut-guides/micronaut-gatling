package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import example.micronaut.Greeting;

@Controller
public class GreetingController {

    @Get("/greeting")
    public Greeting greeting() {
        return new Greeting("Hello, World");
    }
}
