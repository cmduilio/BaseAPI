package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.exceptions.PingException;
import com.samit.entrypoints.dtos.Ping;
import com.samit.entrypoints.validators.PingValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class PingEntrypoint extends Entrypoint implements Route {

    PingValidator pingValidator;

    @Inject
    public PingEntrypoint(PingValidator pingValidator){
        this.pingValidator = pingValidator;
    }

    @Override
    public Object handle(Request request, Response response) {
        Ping ping = (Ping) JsonUtils.fromJson(request.body(), Ping.class);

        if(!this.pingValidator.validate(ping)){
            throw new PingException("Invalid Ping");
        }
        return ping.getMessage();
    }
}