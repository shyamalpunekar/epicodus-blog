package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class BlogTest {

    @Test
    public void NewBlogObjectGetsCorrectlyCreated_true() throws Exception {
        Blog blog = new Blog("Day1: Intro");
        assertEquals(true, blog instanceof Blog);
    }

    @Test
    public void BlogInstantiatesWithFeelings_true() throws Exception {
        Blog blog = new Blog("Day 1: Intro");
        assertEquals("Day 1: Intro", blog.getFeelings());
    }


    @Test
    public void AllBlogssAreCorrectlyReturned_true() throws Exception {
        Blog firstBlog = new Blog("First test");
        Blog secondBlog = new Blog("second test");

        assertEquals(2, Blog.getAll().size());


    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Blog.clearAllBlogs();
    }

}