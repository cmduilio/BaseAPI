package core.usecases;

import com.google.inject.Inject;
import configuration.System;
import entrypoints.dtos.Payment;

public class PaymentMaker {

    private AsociationMaker asociationMaker;

    @Inject
    public PaymentMaker(AsociationMaker asociationMaker) {
        this.asociationMaker = asociationMaker;
    }

    public String run(Payment payment) {
        int paymentId = System.getPayments().size();

        System.getPayments().add(payment);

        asociationMaker.run(paymentId, payment);
        //System.getAsociations().put(chargeId, new ArrayList<>());
        return "Paaaaaaaaaaaay!\n";
    }
}
