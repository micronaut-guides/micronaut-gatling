package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Greeting {
    private final String message;

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
