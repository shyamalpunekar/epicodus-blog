package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class Blog {

    private String feelings;

    private static ArrayList<Blog> instances = new ArrayList<>();

    public Blog(String feelings) {
        this.feelings = feelings;
        instances.add(this);
    }

    public String getFeelings() {
        return feelings;
    }

    public static ArrayList<Blog> getAll(){
        return instances;
    }

    public static void clearAllBlogs() {
        instances.clear();
    }


}

