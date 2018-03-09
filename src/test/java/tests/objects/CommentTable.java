package tests.objects;

import java.util.List;

public interface CommentTable {
    void selectComment(int commentNumber);
    String getCommentText(int commentNumber);
    String getCommentState(int commentNumber);
    List<Comment> getComments();

    void selectComments(int[] commentNumbers);
}
