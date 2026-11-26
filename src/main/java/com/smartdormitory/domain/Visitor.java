package com.smartdormitory.domain;

import java.time.LocalDateTime;

public class Visitor {

    private String visitorName;
    private String residentName;
    private String roomNumber;
    private LocalDateTime visitTime;

    public Visitor(String visitorName, String residentName,
                   String roomNumber) {

        this.visitorName = visitorName;
        this.residentName = residentName;
        this.roomNumber = roomNumber;
        this.visitTime = LocalDateTime.now();
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    @Override
    public String toString() {
        return "Келуші: " + visitorName +
                " | Тұрғын: " + residentName +
                " | Бөлме: " + roomNumber +
                " | Келген уақыты: " + visitTime;
    }
}