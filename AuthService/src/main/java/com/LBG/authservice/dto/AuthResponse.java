package com.LBG.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String type = "Bearer";
    public AuthResponse(String token) {
        this.token = token;
        this.type = "Bearer";
    }
}
