package com.samit.configuration;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.samit.core.exceptions.PingException;
import com.samit.entrypoints.PingEntrypoint;
import com.samit.utils.JsonUtils;
import org.apache.http.HttpStatus;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Main extends AbstractModule {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Main());

        port(8080);
        get("/", (req, res) -> "Hello, World!\n");

        post("/ping", injector.getInstance(PingEntrypoint.class), JsonUtils::toJson);
    }

    @Override
    protected void configure() {
        bind(PingEntrypoint.class);
        exception(PingException.class, this::badRequest);
    }

    //create a handler or something?
    private void badRequest(Exception exception, Request req, Response res) {
        res.status(HttpStatus.SC_BAD_REQUEST);
        res.body("");
    }
}
