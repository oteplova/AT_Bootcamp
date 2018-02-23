package net.comments.objects;

public class BComment {
    private final String commentNumber;
    private final String commentText;
    private final String commentActivation;
    private final String commentCategories;

    public BComment(String commentNumber, String commentText, String commentActivation, String commentCategories) {
        this.commentNumber = commentNumber;
        this.commentText = commentText;
        this.commentActivation = commentActivation;
        this.commentCategories = commentCategories;
    }

    public String getCommentNumber() {
        return this.commentNumber;
    }

    public String getCommentText() {
        return this.commentText;
    }
}
