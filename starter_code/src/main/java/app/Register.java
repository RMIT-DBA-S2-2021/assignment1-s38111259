package app;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Register implements Handler {
    public static final String URL = "/register.html";
    private static final String TEMPLATE = ("register.html");
   @Override
   public void handle(Context context) throws Exception {
      Map<String, Object> model = new HashMap<String, Object>();
      context.render(TEMPLATE, model);
   }
}
