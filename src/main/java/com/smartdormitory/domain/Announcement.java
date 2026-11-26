package com.smartdormitory.domain;

import java.time.LocalDateTime;

public class Announcement {

    private String title;
    private String message;
    private LocalDateTime createdAt;

    public Announcement(String title, String message) {
        this.title = title;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Тақырып: " + title +
                "\nХабарландыру: " + message +
                "\nЖарияланған уақыты: " + createdAt;
    }
}