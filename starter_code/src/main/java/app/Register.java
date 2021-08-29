package app;

import java.util.HashMap;
import java.util.Map;

import app.doa.UserRegisterDaoImpl;
import app.service.UserDetailServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Register implements Handler {
    public static final String URL = "/register.html";

   // Name of the Thymeleaf HTML template page in the resources folder
   private static final String TEMPLATE = ("register.html");
   UserDetailServiceImpl userDetailServiceImpl;

   @Override
   public void handle(Context context) throws Exception {
      System.out.println("hi");
        Map<String, Object> model = new HashMap<String, Object>();
        String email = context.formParam("email");
        String fname = context.formParam("fname");
        String password = context.formParam("psk");
        String conf_pass = context.formParam("cpsk");
        String screen_name = context.formParam("sname");
        String dob = context.formParam("date");
        String gender = context.formParam("gender");
        String status = context.formParam("status");
        String location = context.formParam("location");
        String visible = context.formParam("visible");
        System.out.println(dob);
        UserRegisterDaoImpl userRegisterDaoImpl=new UserRegisterDaoImpl();
        userRegisterDaoImpl.saveUserDetailDB(email,fname, password, screen_name, dob, gender, status, location,visible);
        
        if(fname!=null || password!=null || conf_pass!=null || screen_name!=null || dob!=null || gender!=null || status!=null || location!=null){
            
        }
        else{

        }
        context.render(TEMPLATE, model);
      context.render(TEMPLATE);
   }
    
}
