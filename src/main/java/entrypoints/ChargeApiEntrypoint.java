package entrypoints;

import com.google.inject.Inject;
import core.usecases.ChargeMaker;
import entrypoints.dtos.Charge;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class ChargeApiEntrypoint extends Entrypoint implements Route {

    private ChargeMaker chargeMaker;

    List<List<Charge>> facturas;

    @Inject
    public ChargeApiEntrypoint(ChargeMaker chargeMaker) {
        this.chargeMaker = chargeMaker;
    }

    @Override
    public String handle(Request request, Response response) {
        Charge charge = (Charge) parseBody(request.body(), Charge.class);
        return chargeMaker.run(charge);
    }
}