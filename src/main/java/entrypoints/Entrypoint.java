package entrypoints;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Entrypoint {

    private static final Logger log = LoggerFactory.getLogger(Entrypoint.class);
    Gson gson = new Gson();

    public Object parseBody(String body, Class clazz) {
        Object obj = null;
        try{
            obj = this.gson.fromJson(body, clazz);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

}
