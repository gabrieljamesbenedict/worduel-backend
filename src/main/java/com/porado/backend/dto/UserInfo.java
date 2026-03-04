package com.porado.backend.dto;

import com.porado.backend.model.User;
import lombok.Data;

@Data
public class UserInfo {
    private Long userId;
    private String username;
    private String role;

    public UserInfo(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.role = user.getRole();
    }
}
