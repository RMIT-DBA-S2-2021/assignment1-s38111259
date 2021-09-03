// @authors Preet Choudhary & Viet Tran 
package app;

import javax.servlet.http.HttpSession;
import app.service.UserDetailUpdateServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Update implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/update.html";

    // Name of the Thymeleaf HTML template page in the resources folder
    private static final String TEMPLATE = ("update.html");

    @Override
    public void handle(Context context) throws Exception {
        HttpSession session=context.req.getSession();
        String email=(String) session.getAttribute("emailAddressColumn");
        String screenName=context.formParam("sname");
        String status=context.formParam("status");
        String location=context.formParam("location");
        String visible=context.formParam("visible");
        
        if(screenName!=null){
            UserDetailUpdateServiceImpl userDetailUpdareServiceImpl=new UserDetailUpdateServiceImpl();
            userDetailUpdareServiceImpl.updateUserDetail(email, screenName, status, location, visible);
        }
  
        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage using Thymeleaf
        // Map<String, Object> model = new HashMap<String, Object>();
        context.render(TEMPLATE);

    }

}
