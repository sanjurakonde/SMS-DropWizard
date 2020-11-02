package com.dropwizard;

import com.flipkart.rest.AdminController;
import com.flipkart.rest.ProfessorController;
import com.flipkart.rest.StudentController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration configuration, Environment e) {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new AdminController());
        e.jersey().register(new ProfessorController());
        e.jersey().register(new StudentController());
    }

    public static void main(String[] args) throws Exception {
        String applicationPort = "9090";
        String adminPort = "9091";

        System.setProperty("dw.server.applicationConnectors[0].port", applicationPort);
        System.setProperty("dw.server.adminConnectors[0].port", adminPort);
        new App().run(args);
    }
}
