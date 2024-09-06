package com.tes;

public class LoginResponse {
    private Long id;
    private String username;

    // No-argument constructor
    public LoginResponse() {}

    // Parameterized constructor
    public LoginResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
