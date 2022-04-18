package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.CandidateStore;

import java.util.Collection;

@Service
@ThreadSafe
public class CandidateService {
    private final CandidateStore store;

    public CandidateService(CandidateStore store) {
        this.store = store;
    }

    public Collection<Candidate> findAll() {
        return store.findAll();
    }

    public Candidate create(Candidate candidate) {
        return store.create(candidate);
    }

    public Candidate update(Candidate candidate) {
        return store.update(candidate);
    }

    public Candidate findById(int id) {
        return store.findById(id);
    }
}
