// @authors Preet Choudhary & Viet Tran 
package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Search implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/search.html";

    // Name of the Thymeleaf HTML template page in the resources folder
    private static final String TEMPLATE = ("search.html");

    @Override
    public void handle(Context context) throws Exception {

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage using Thymeleaf
        // Map<String, Object> model = new HashMap<String, Object>();
        context.render(TEMPLATE);

    }

}
