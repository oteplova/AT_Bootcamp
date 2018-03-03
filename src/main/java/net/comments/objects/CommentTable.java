package net.comments.objects;

import java.util.List;

public interface CommentTable {
    void selectComment(int commentNumber);

    String getCommentText(int commentNumber);
    List<Comment> getComments();
}
