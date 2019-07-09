package core.usecases;

import com.google.inject.Inject;
import configuration.System;
import entrypoints.dtos.Charge;

import java.util.ArrayList;

public class ChargeMaker {

    @Inject
    public ChargeMaker() {
    }

    public String run(Charge charge) {
        int chargeId = System.getCharges().size();

        System.getCharges().add(charge);
        System.getAsociations().put(chargeId, new ArrayList<>());
        System.setDebt(System.getDebt() + charge.getAmount());
        return "Chaaaaaaar!\n";
    }
}
