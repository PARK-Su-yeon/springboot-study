package com.example.music.post.entity;

import java.security.Principal;

public class CustomPrincipal implements Principal {

    private Long userId; // Assuming you store the user ID in your custom principal

    public CustomPrincipal(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return String.valueOf(userId);
    }

    public Long getUserId() {
        return userId;
    }
}