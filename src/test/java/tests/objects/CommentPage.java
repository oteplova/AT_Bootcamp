package tests.objects;

public interface CommentPage {
    void open();
    void newComment();
    CommentActions getCommentAction();
    CommentTable getCurrentComments();
    CommentTable getCommentsFrom(int page);
    BCommentManager getCommentManager();
    Pagination getPagination();
    CommentModifier getCommentModifier();

    CommentErrors getCommentError();
}
