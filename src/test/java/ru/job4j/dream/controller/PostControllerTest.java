package ru.job4j.dream.controller;

import org.junit.Test;
import org.springframework.ui.Model;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.service.CityService;
import ru.job4j.dream.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class PostControllerTest {

    @Test
    public void whenPosts() {
        List<Post> posts = Arrays.asList(
                new Post(1, "New post"),
                new Post(2, "New post")
        );
        Model model = mock(Model.class);
        PostService postService = mock(PostService.class);
        when(postService.findAll()).thenReturn(posts);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService
        );
        HttpSession httpSession = mock(HttpSession.class);
        String page = postController.posts(model, httpSession);
        verify(model).addAttribute("posts", posts);
        assertThat(page, is("posts"));
    }

    @Test
    public void whenCreatePost() {
        Post inputPost = new Post(1, "New post");
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService
        );
        String page = postController.createPost(inputPost);
        verify(postService).create(inputPost);
        assertThat(page, is("redirect:/posts"));
    }

    @Test
    public void whenUpdatePost() {
        Post newPost = new Post(1, "New post");
        Post updatePost = new Post(1, "Updated post");
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService
        );
        postController.createPost(newPost);
        String page = postController.updatePost(updatePost);
        verify(postService).update(updatePost);
        assertThat(page, is("redirect:/posts"));
    }

    @Test
    public void whenAddPost() {
        Model model = mock(Model.class);
        HttpSession httpSession = mock(HttpSession.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService
        );
        String page = postController.addPost(model, httpSession);
        verify(model).addAttribute("cities", cityService.getAllCities());
        assertThat(page, is("addPost"));
    }

    @Test
    public void whenFormUpdatePost() {
        Post post = new Post(1, "New post");
        post.setCity(new City(1, null));
        Model model = mock(Model.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);
        PostController postController = new PostController(
                postService,
                cityService
        );
        when(postService.findById(post.getId())).thenReturn(post);
        String page = postController.formUpdatePost(model, post.getId());
        verify(model).addAttribute("cities", cityService.getAllCities());
        verify(model).addAttribute("post", post);
        assertThat(page, is("updatePost"));
    }
}