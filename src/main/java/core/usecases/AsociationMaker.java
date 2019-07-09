package core.usecases;

import com.google.inject.Inject;
import configuration.System;
import core.entities.Asociation;
import entrypoints.dtos.Payment;

public class AsociationMaker {

    @Inject
    public AsociationMaker() {
    }

    public void run(int paymentId, Payment payment){
        Double amount = 300D;
        while(amount > 0D){
            Asociation asociation = new Asociation();
            asociation.setPaymentId(Long.valueOf(paymentId));
            asociation.setAmount(amount);
            System.getAsociations().get(System.getLastChargeUnpaid()).add(asociation);
            amount -= 100D;
        }
    }
}
