package ru.job4j.dream.service;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostStore;

import java.util.Collection;

public class PostService {
    private final PostStore store;

    public PostService() {
        this.store = PostStore.instOf();
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }

    public Post create(Post post) {
        return store.create(post);
    }

    public Post update(Post post) {
        return store.update(post);
    }

    public Post findById(int id) {
        return store.findById(id);
    }
}
