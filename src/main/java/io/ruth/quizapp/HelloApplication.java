
package io.ruth.quizapp;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    @PostConstruct
    public void init() {
        System.out.println("HelloApplication started");
    }
}


