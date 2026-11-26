package com.smartdormitory.service;

import com.smartdormitory.domain.Request;

public abstract class RequestFactory {

    public abstract Request createRequest(
            int id,
            String residentName,
            String roomNumber,
            String description,
            String category
    );
}