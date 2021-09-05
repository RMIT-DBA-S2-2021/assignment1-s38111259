package app;

import java.util.HashMap;
import java.util.Map;

import app.service.UserRegisterServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Register_Response implements Handler {
    public static final String URL = "/register_response.html";
    private static final String TEMPLATE = ("register_response.html");

    @Override
    public void handle(Context context) throws Exception {
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
          boolean isInserted=false;
          if(!(password.equals(conf_pass))){
            model.put("psk_err", "Password doesn't macthes");
            context.render(TEMPLATE, model);
         }
          else if(fname!=null || password!=null || conf_pass!=null || screen_name!=null || dob!=null || gender!=null || status!=null || location!=null){
              UserRegisterServiceImpl userRegisterServiceImpl=new UserRegisterServiceImpl();
              isInserted=userRegisterServiceImpl.saveUserDetail(email,fname, password, screen_name, dob, gender, status, location,visible);
              if (isInserted) {
                 model.put("Message", "You have Registered Successfully");
                 context.render(TEMPLATE, model);           
              }
              else{
                 model.put("Failure_MSG", "You haven't Registered Successfully! Try again!");
                 context.render(TEMPLATE, model);      
              }
           }      
    } 
}
