package net.comments.objects;

import java.util.List;

public interface CommentTable {

    void selectComment(int commentsNumber);

    List<Comment> getComments();

}