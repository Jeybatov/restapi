package edu.ada.micronaunt;

import edu.ada.micronaunt.service.RegisterService;
import groovy.transform.CompileStatic;
import io.micronaut.runtime.Micronaut;
import javax.inject.Singleton;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;


@CompileStatic
@Singleton
public class Application {
    protected final RegisterService registerService;

    Application(RegisterService registerService) {
        this.registerService = registerService;
    }

    void onApplicationEvent(ServerStartupEvent event) {
        registerService.register("jeybatov2021@ada.edu.az", "Jamil", "qwerty");
    }

    static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
