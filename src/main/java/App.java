import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/" , (request, response) -> {
            Map<String , Object> model =  new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/blogs/new" , (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String bananas = request.queryParams("inputFeelings");
            Blog newBlog = new Blog(bananas);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
