package entrypoints.validators;

import com.google.inject.Inject;
import configuration.System;
import entrypoints.dtos.Payment;

public class PaymentValidator {

    @Inject
    public PaymentValidator() {
    }

    public boolean validate(Payment payment){
        boolean validated = true;

        if(payment.getAmount() > System.getDebt()){
            validated = false;
        }
        return validated;
    }
}
