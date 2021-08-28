package app;

import java.util.HashMap;
import java.util.Map;
import app.service.UserDetailServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class home implements Handler {
    public static final String URL = "/home.html";

   private static final String TEMPLATE = ("home.html");
   UserDetailServiceImpl userDetailServiceImpl;
   
    public void handle(Context context) throws Exception {

      Map<String, Object> model = new HashMap<String, Object>();
      context.render(TEMPLATE, model);
}
}
