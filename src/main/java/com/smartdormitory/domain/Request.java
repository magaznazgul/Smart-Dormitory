package com.smartdormitory.domain;

public class Request {

    private int id;
    private String residentName;
    private String roomNumber;
    private String description;
    private String category;
    private RequestStatus status;

    public Request(int id, String residentName,
                   String roomNumber, String description,
                   String category) {

        this.id = id;
        this.residentName = residentName;
        this.roomNumber = roomNumber;
        this.description = description;
        this.category = category;
        this.status = RequestStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Өтінім №" + id +
                " | Тұрғын: " + residentName +
                " | Бөлме: " + roomNumber +
                " | Сипаттама: " + description +
                " | Санат: " + category +
                " | Күйі: " + status;
    }
}