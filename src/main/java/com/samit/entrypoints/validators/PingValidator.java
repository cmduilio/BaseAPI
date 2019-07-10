package com.samit.entrypoints.validators;

import com.google.inject.Inject;
import com.samit.entrypoints.dtos.Ping;

public class PingValidator {

    @Inject
    public PingValidator() {
    }

    public boolean validate(Ping ping){

        return !ping.getMessage().isEmpty();
    }
}
