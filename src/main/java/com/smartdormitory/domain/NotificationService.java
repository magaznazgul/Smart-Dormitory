package com.smartdormitory.domain;

public interface NotificationService {
    void sendNotification(String phoneNumber, String message);
}