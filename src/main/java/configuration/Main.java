package configuration;

        import com.google.inject.AbstractModule;
        import com.google.inject.Guice;
        import com.google.inject.Injector;
        import core.usecases.AsociationMaker;
        import core.usecases.ChargeMaker;
        import core.usecases.PaymentMaker;
        import entrypoints.ChargeApiEntrypoint;
        import entrypoints.PaymentApiEntrypoint;

        import static spark.Spark.*;

public class Main extends AbstractModule {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Main());

        port(8080);
        get("/", (req, res) -> "Hello, World!\n");
        get("/charges", (req, res) -> "Charges!\n");
        get("/bills", (req, res) -> "Bills!\n");
        get("/payments", (req, res) -> "Payments!\n");
        get("/status", (req, res) -> "Status!\n");

        post("/charge", injector.getInstance(ChargeApiEntrypoint.class));
        post("/payment", injector.getInstance(PaymentApiEntrypoint.class));
    }

    @Override
    protected void configure() {
        bind(ChargeMaker.class);
        bind(PaymentMaker.class);
        bind(AsociationMaker.class);
        bind(ChargeApiEntrypoint.class);
        bind(PaymentApiEntrypoint.class);
    }

}
