// @authors Preet Choudhary & Viet Tran 
package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Request implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/request.html";

    // Name of the Thymeleaf HTML template page in the resources folder
    private static final String TEMPLATE = ("request.html");

    @Override
    public void handle(Context context) throws Exception {

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage using Thymeleaf
        context.render(TEMPLATE);

    }

}