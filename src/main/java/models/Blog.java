package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class Blog {

    private String feelings;

    private boolean published;

    private LocalDateTime createdAt;
    private static ArrayList<Blog> instances = new ArrayList<>();

    public Blog(String feelings) {
        this.feelings = feelings;
        instances.add(this);
        this.published = false;
        this.createdAt = LocalDateTime.now();
    }

    public String getFeelings() {
        return feelings;
    }

    //Displaying Custom Objects
    public static ArrayList<Blog> getAll(){
        return instances;
    }

    public static void clearAllBlogs() {
        instances.clear();
    }

    public boolean getPublished() {
        return published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

