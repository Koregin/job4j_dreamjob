package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.UserDBStore;

@Service
public class UserService {
    private final UserDBStore store;

    public UserService(UserDBStore store) {
        this.store = store;
    }

    public User add(User user) {
        return store.create(user);
    }
}
