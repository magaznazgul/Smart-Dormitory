package com.smartdormitory.infra;

import com.smartdormitory.domain.NotificationService;

public class SmsNotificationAdapter implements NotificationService {

    private final LegacySmsService legacySmsService;

    public SmsNotificationAdapter(LegacySmsService legacySmsService) {
        this.legacySmsService = legacySmsService;
    }

    @Override
    public void sendNotification(String phoneNumber, String message) {
        legacySmsService.sendSms(message, phoneNumber);
    }
}