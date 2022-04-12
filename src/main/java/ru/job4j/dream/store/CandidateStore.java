package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CandidateStore {
    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Mark Otto",
                "Junior", LocalDate.of(2022, 4, 12)));
        candidates.put(2, new Candidate(2, "Jacob Thornton",
                "Middle", LocalDate.of(2022, 4, 12)));
        candidates.put(3, new Candidate(3, "Larry the Bird",
                "Senior", LocalDate.of(2022, 4, 12)));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
