package com.techelevator.model;

public class CommentDTO {

    private int commentId;
    private int photoId;
    private String comment;

    public CommentDTO(){}

    public CommentDTO(int commentId, int photoId, String comment) {
        this.commentId = commentId;
        this.photoId = photoId;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
