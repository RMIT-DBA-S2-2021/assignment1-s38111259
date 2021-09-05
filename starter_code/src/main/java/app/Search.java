// @authors Preet Choudhary & Viet Tran 
package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import app.service.UserSearchServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Search implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/search.html";

    // Name of the Thymeleaf HTML template page in the resources folder
    private static final String TEMPLATE = ("search.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        UserSearchServiceImpl userSearchServiceImpl = new UserSearchServiceImpl();
        String fname = context.formParam("search");
        if(fname!=null){
            ArrayList<String> member = userSearchServiceImpl.searchUserDetail(fname);
            for(int i=0;i<member.size();i++){
                model.put("member", member.get(i));
            }
            context.render(TEMPLATE,model);
        }
        context.render(TEMPLATE,model);
        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage using Thymeleaf
        

    }

}
