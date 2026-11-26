package com.smartdormitory.infra;

import com.smartdormitory.domain.Request;
import com.smartdormitory.domain.RequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRequestRepository implements RequestRepository {

    private final List<Request> requests = new ArrayList<>();

    @Override
    public void save(Request request) {
        requests.add(request);
    }

    @Override
    public List<Request> findAll() {
        return new ArrayList<>(requests);
    }

    @Override
    public Optional<Request> findById(int id) {
        return requests.stream()
                .filter(request -> request.getId() == id)
                .findFirst();
    }
}