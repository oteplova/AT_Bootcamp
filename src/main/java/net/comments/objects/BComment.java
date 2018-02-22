package net.comments.objects;

public class BComment {
    final String commentNumber;
    final String commentText;
    final String commentActivation;
    final String commentCategories;

    public BComment(String commentNumber, String commentText, String commentActivation, String commentCategories) {
        this.commentNumber = commentNumber;
        this.commentText = commentText;
        this.commentActivation = commentActivation;
        this.commentCategories = commentCategories;
    }
}
