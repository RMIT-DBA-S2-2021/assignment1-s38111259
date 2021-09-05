package app;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpSession;


import app.service.UserDetailServiceImpl;
import app.service.UserPostServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class home implements Handler {
    public static final String URL = "/home.html";

   private static final String TEMPLATE = ("home.html");
   UserDetailServiceImpl userDetailServiceImpl;
   
    public void handle(Context context) throws Exception {
      Random rnd = new Random();
      int random = rnd.nextInt(2147483647);
      Map<String, Object> model = new HashMap<String, Object>();
      HttpSession session = context.req.getSession();
      String email = (String) session.getAttribute("emailAddressColumn");
      String post_responseID = Integer.toString(random);
      String body = context.formParam("postbox");
      
      //Retreive and convert to timestamp
      Date date = new Date();
      Timestamp timestamp = new Timestamp(date.getTime());
      String timestamp1 = timestamp.toString();
      boolean isPosted=false;

      if(body!=null){
        UserPostServiceImpl userPostServiceImpl = new UserPostServiceImpl();
        isPosted = userPostServiceImpl.userPostDetail(post_responseID, body, timestamp1, null, null, email, null);
        if (isPosted) {
          model.put("Message", "You have posted Successfully");
          context.render(TEMPLATE, model);           
       }
       else{
          model.put("Failure_MSG", "Your post was not posted. Try again later!");
          context.render(TEMPLATE, model);      
       }
      }
      context.render(TEMPLATE, model);
}
}
