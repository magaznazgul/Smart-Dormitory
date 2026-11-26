package com.smartdormitory.service;

import com.smartdormitory.domain.Request;
import com.smartdormitory.domain.RepairRequest;

public class RepairRequestFactory extends RequestFactory {

    @Override
    public Request createRequest(
            int id,
            String residentName,
            String roomNumber,
            String description,
            String category
    ) {
        return new RepairRequest(
                id, residentName, roomNumber, description
        );
    }
}