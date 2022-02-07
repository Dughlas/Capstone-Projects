package com.techelevator.model;

public class ProfileDTO {
    private int userId;
    private String bio;
    private String profilePicUrl;

    public ProfileDTO(int userId, String bio, String profilePicUrl) {
        this.userId = userId;
        this.bio = bio;
        this.profilePicUrl = profilePicUrl;
    }

    public int getUserId() {
        return userId;
    }

    public String getBio() {
        return bio;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }
}
