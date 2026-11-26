package com.smartdormitory.domain;

public class RepairRequest extends Request {

    public RepairRequest(int id, String residentName,
                         String roomNumber, String description) {

        super(id, residentName, roomNumber,
                description, "Жөндеу жұмыстары");
    }
}