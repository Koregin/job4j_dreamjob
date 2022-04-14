package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateStore {
    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger(0);

    private CandidateStore() {
        candidates.put(1, new Candidate(counter.incrementAndGet(), "Mark Otto",
                "Junior", LocalDate.of(2022, 4, 12)));
        candidates.put(2, new Candidate(counter.incrementAndGet(), "Jacob Thornton",
                "Middle", LocalDate.of(2022, 4, 12)));
        candidates.put(3, new Candidate(counter.incrementAndGet(), "Larry the Bird",
                "Senior", LocalDate.of(2022, 4, 12)));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public Candidate create(Candidate candidate) {
        candidate.setId(counter.incrementAndGet());
        candidate.setCreated(LocalDate.now());
        return candidates.put(candidate.getId(), candidate);
    }

    public Candidate update(Candidate candidate) {
        candidate.setCreated(LocalDate.now());
        return candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }
}
