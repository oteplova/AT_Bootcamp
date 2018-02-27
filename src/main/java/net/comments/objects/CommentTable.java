package net.comments.objects;

import java.util.List;

public interface CommentTable {
    void selectComment(String commentNumber);
    List<Comment> getComments();
}
