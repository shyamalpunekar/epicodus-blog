package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class BlogTest {

    @Test
    public void NewBlogObjectGetsCorrectlyCreated_true() throws Exception {
        Blog blog = setupNewBlog();
        assertEquals(true, blog instanceof Blog);
    }

    @Test
    public void BlogInstantiatesWithFeelings_true() throws Exception {
        Blog blog = setupNewBlog();
        assertEquals("Testing setup", blog.getFeelings());
    }


    @Test
    public void AllBlogssAreCorrectlyReturned_true() throws Exception {
        Blog firstBlog = setupNewBlog();
        Blog secondBlog = new Blog("second test");

        assertEquals(2, Blog.getAll().size());
    }

    @Test
    public void sFalseAfterInstantiation_false() throws Exception {
        Blog blog = setupNewBlog();
        assertEquals(false, blog.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Blog myBlog = setupNewBlog();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myBlog.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_blogsInstantiateWithAnID_1() throws Exception {
        Blog.clearAllBlogs();// Remember, the test will fail without this line!
        // We need to empty leftover Blogs from previous tests!
        Blog myBlog = setupNewBlog();
        assertEquals(1, myBlog.getId());
    }

    @Test
    public void findReturnsCorrectBlogWhenMoreThanOneBlogExists() throws Exception {
        Blog Blog = setupNewBlog();
        Blog otherBlog = new Blog("How to pair successfully");
        assertEquals(2, Blog.findById(otherBlog.getId()).getId());
    }

    //Finding Specific Objects
    @Test
    public void findReturnsCorrectBlog() throws Exception {
        Blog blog = setupNewBlog();
        assertEquals(1, Blog.findById(blog.getId()).getId());
    }

    public Blog setupNewBlog(){
        return new Blog("Testing setup");
    }

    @Test
    public void updateChangesBlogContent() throws Exception {
        Blog blog = setupNewBlog();
        String firstInput = blog.getFeelings();
        LocalDateTime retrieveDateInfo = blog.getCreatedAt();
        int retrieveId = blog.getId();

        blog.update("Testing setup");

        assertEquals(firstInput, blog.getFeelings());
        assertEquals(retrieveDateInfo, blog.getCreatedAt());
        assertEquals(retrieveId , blog.getId());

    }

    @Test
    public void deleteDeletesASpecificBlog() throws Exception {
        Blog Blog = setupNewBlog();
        Blog otherBlog = new Blog("How to pair successfully");
        Blog.deleteBlog();
        assertEquals(1, Blog.getAll().size()); //one is left
        assertEquals(Blog.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }


    @Test
    public void deleteAllBlogsDeletesAllBlogs() throws Exception {
        Blog Blog = setupNewBlog();
        Blog otherBlog = setupNewBlog();

        Blog.clearAllBlogs();
        assertEquals(0, Blog.getAll().size());
    }
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Blog.clearAllBlogs();
    }

}