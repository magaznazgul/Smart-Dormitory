package com.smartdormitory.service;

import com.smartdormitory.domain.Request;
import com.smartdormitory.domain.RequestRepository;
import com.smartdormitory.domain.RequestStatus;

import java.util.ArrayList;
import java.util.List;

public class RequestService {

    private final RequestRepository repository;

    private final List<RequestObserver> observers = new ArrayList<>();

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public void addObserver(RequestObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Request request) {
        for (RequestObserver observer : observers) {
            observer.onStatusChanged(request);
        }
    }

    public void createRequest(
            int id,
            String residentName,
            String roomNumber,
            String description,
            String category
    ) {

        RequestFactory factory;

        if (category.equalsIgnoreCase("repair")) {
            factory = new RepairRequestFactory();
        } else {
            factory = new GeneralRequestFactory();
        }

        Request request = factory.createRequest(
                id, residentName, roomNumber, description, category
        );

        repository.save(request);
    }

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

    public void updateStatus(int id, RequestStatus status) {

        Request request = repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Өтінім табылмады!")
                );

        request.setStatus(status);

        notifyObservers(request);
    }
}