package com.smartdormitory.service;

import com.smartdormitory.domain.Request;

public class GeneralRequestFactory extends RequestFactory {

    @Override
    public Request createRequest(
            int id,
            String residentName,
            String roomNumber,
            String description,
            String category
    ) {
        return new Request(
                id, residentName, roomNumber, description, category
        );
    }
}