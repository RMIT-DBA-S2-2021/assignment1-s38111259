// @authors Preet Choudhary & Viet Tran 
package app;

import javax.servlet.http.HttpSession;

import app.service.UserDeleteServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Delete implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/delete.html";

    // Name of the Thymeleaf HTML template page in the resources folder
    private static final String TEMPLATE = ("delete.html");

    @Override
    public void handle(Context context) throws Exception {
        HttpSession session = context.req.getSession();
        String email=(String) session.getAttribute("emailAddressColumn");
        UserDeleteServiceImpl userDeleteServiceImpl = new UserDeleteServiceImpl();
        userDeleteServiceImpl.deleteUserDetail(email);
        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage using Thymeleaf
        // Map<String, Object> model = new HashMap<String, Object>();
        context.render(TEMPLATE);

    }

}