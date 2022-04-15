package ru.job4j.dream.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStore {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    private PostStore() {
        posts.put(1, new Post(counter.incrementAndGet(), "Junior Java Job",
                "Job for junior", LocalDate.of(2022, 4, 12)));
        posts.put(2, new Post(counter.incrementAndGet(), "Middle Java Job",
                "Job for middle", LocalDate.of(2022, 4, 12)));
        posts.put(3, new Post(counter.incrementAndGet(), "Senior Java Job",
                "Job for senior", LocalDate.of(2022, 4, 12)));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post create(Post post) {
        post.setId(counter.incrementAndGet());
        post.setCreated(LocalDate.now());
        return posts.put(post.getId(), post);
    }

    public Post update(Post post) {
        post.setCreated(LocalDate.now());
        return posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }
}