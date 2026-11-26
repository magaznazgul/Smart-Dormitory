package com.smartdormitory.domain;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {

    void save(Request request);

    List<Request> findAll();

    Optional<Request> findById(int id);
}