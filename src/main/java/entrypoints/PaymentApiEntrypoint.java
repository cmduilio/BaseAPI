package entrypoints;

import core.usecases.PaymentMaker;
import entrypoints.dtos.Payment;
import entrypoints.validators.PaymentValidator;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.inject.Inject;

public class PaymentApiEntrypoint extends Entrypoint implements Route {

    private PaymentMaker paymentMaker;
    private PaymentValidator paymentValidator;

    @Inject
    public PaymentApiEntrypoint(PaymentMaker paymentMaker, PaymentValidator paymentValidator) {
        this.paymentMaker = paymentMaker;
        this.paymentValidator = paymentValidator;
    }

    @Override
    public String handle(Request request, Response response) {
        Payment payment = (Payment) parseBody(request.body(), Payment.class);

        if(!this.paymentValidator.validate(payment)){
            return "exception";
        }

        return paymentMaker.run(payment);
    }
}