package net.comments.objects;

import java.util.List;

public interface CommentTable {
    void selectComment(int commentNumber);

    String getTextSelectedComment(int commentNumber);
    List<Comment> getComments();
}
