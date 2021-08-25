package app;

import java.util.HashMap;
import java.util.Map;

import app.model.UserDetailM;
import app.service.UserDetailServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class login implements Handler {
    public static final String URL = "/login.html";

   // Name of the Thymeleaf HTML template page in the resources folder
   private static final String TEMPLATE = ("home.html");
   UserDetailServiceImpl userDetailServiceImpl;

   @Override
   public void handle(Context context) throws Exception {
      UserDetailM userDetailM = new UserDetailM();
      Map<String, Object> model = new HashMap<String, Object>();
      String username = context.formParam("email");
      String password = context.formParam("pass");
      // System.out.println("Username: "+username+"\nPassword: "+password);
      // model.put("email", username);
      // model.put("pass", password);
      userDetailServiceImpl = new UserDetailServiceImpl();
      userDetailM = userDetailServiceImpl.getUserDetail(username, password);
      if(null!=userDetailM && userDetailM.getEmailAddress()!=null){
         model.put("message", "You are Succesfully login");
         model.put("username", userDetailM.getFullName());
         context.render(TEMPLATE, model);
      }
      else{
         model.put("message", "Username, Password incorrect");
         context.render("index.html", model);
      }
      
    //   // DO NOT MODIFY THIS
    //   // Makes Javalin render the webpage using Thymeleaf
   }
    
}
