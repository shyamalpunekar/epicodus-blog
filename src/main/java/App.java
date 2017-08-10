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

        //get: show new post form
        get("/blogs/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());

        //Creating Objects with a POST Request
        post("/blogs/new" , (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String bananas = request.queryParams("inputFeelings");
            Blog newBlog = new Blog(bananas);
            ArrayList<Blog> myBlogs = Blog.getAll();
            model.put("blogs", myBlogs);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //showing all posts
        get("/" , (request, response) -> {
            Map<String , Object> model =  new HashMap<String, Object>();
            ArrayList<Blog> blogs = Blog.getAll();
            model.put("blogs", blogs);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show individual post
        get("/blogs/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfBlogToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Blog foundPost = Blog.findById(idOfBlogToFind); //use it to find post
            model.put("blog", foundPost); //add it to model for template to display
            return new ModelAndView(model, "post-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a post
        get("/blogs/:id/update" , (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        int idOfBlogToEdit = Integer.parseInt(request.params("id"));
        Blog editBlog = Blog.findById(idOfBlogToEdit);
        return new ModelAndView(model, "post-form.hbs");
        },new HandlebarsTemplateEngine());

        //post : process a form to updates in post
        post("/blogs: id/update" , (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newFeelings = request.queryParams("inputFeelings");
            int idOfBlogToEdit = Integer.parseInt(request.params("id"));
            Blog editBlog = Blog.findById(idOfBlogToEdit);
            editBlog.update(newFeelings);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //showing all posts
        get("/blogs" , (request, response) -> {
            Map<String , Object> model =  new HashMap<String, Object>();
            ArrayList<Blog> blogs = Blog.getAll();
            model.put("blogs", blogs);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Blog deleteBlog = Blog.findById(idOfPostToDelete); //use it to find post
            deleteBlog.deleteBlog();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Blog.clearAllBlogs();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
