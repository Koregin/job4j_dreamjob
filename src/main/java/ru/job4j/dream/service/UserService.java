package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.UserDBStore;

import java.util.Optional;

@Service
public class UserService {
    private final UserDBStore store;

    public UserService(UserDBStore store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return store.create(user);
    }
}
