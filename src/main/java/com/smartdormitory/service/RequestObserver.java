package com.smartdormitory.service;

import com.smartdormitory.domain.Request;

public interface RequestObserver {
    void onStatusChanged(Request request);
}