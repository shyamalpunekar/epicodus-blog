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
        // We need to empty leftover Posts from previous tests!
        Blog myBlog = setupNewBlog();
        assertEquals(1, myBlog.getGetId());


    }

    public Blog setupNewBlog(){
        return new Blog("Testing setup");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Blog.clearAllBlogs();
    }

}