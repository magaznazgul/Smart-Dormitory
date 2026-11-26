package com.smartdormitory.service;

import com.smartdormitory.domain.Request;

public class ResidentNotificationObserver implements RequestObserver {

    @Override
    public void onStatusChanged(Request request) {
        System.out.println(
                "ХАБАРЛАМА: Құрметті " + request.getResidentName()
                        + ", №" + request.getId()
                        + " өтініміңіздің жаңа күйі: " + request.getStatus()
        );
    }
}