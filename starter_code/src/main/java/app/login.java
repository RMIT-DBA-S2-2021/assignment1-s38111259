package app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import app.dto.UserLoginDetailM;
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
      HttpSession session = context.req.getSession();
      

      userDetailServiceImpl = new UserDetailServiceImpl();
      userDetailM = userDetailServiceImpl.getUserDetail(username, password);

      if(null!=userDetailM && userDetailM.getEmailAddress()!=null){
         session.setAttribute("emailAddressColumn", userDetailM.getEmailAddress());
         model.put("message", "You are Succesfully login");
         model.put("username", userDetailM.getFullName());
         context.render(TEMPLATE, model);
      }
      else{
         model.put("message", "Username, Password incorrect");
         context.render("index.html", model);
      }
   }
    
}
