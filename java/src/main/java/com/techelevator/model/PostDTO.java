package com.techelevator.model;

public class PostDTO {
    private int userId;
    private int photoId;
    private String url;
    private String caption;

    public PostDTO(int userId, int photoId, String url, String caption) {
        this.userId = userId;
        this.photoId = photoId;
        this.url = url;
        this.caption = caption;
    }

    public int getUserId() {
        return userId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getUrl() {
        return url;
    }

    public String getCaption() {
        return caption;
    }
}
