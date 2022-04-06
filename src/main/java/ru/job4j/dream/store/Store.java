package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Description of Junior Java Job",
                LocalDate.of(2022, 1, 25)));
        posts.put(2, new Post(2, "Middle Java Job", "Description of Middle Java job",
                LocalDate.of(2022, 2, 13)));
        posts.put(3, new Post(3, "Senior Java Job", "Description of Senior Java Job",
                LocalDate.of(2022, 3, 28)));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }
}
