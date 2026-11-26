package com.smartdormitory.infra;

public class LegacySmsService {

    public void sendSms(String message, String phoneNumber) {
        System.out.println("SMS жіберілді!");
        System.out.println("Нөмір: " + phoneNumber);
        System.out.println("Мәтін: " + message);
    }
}