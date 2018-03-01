package net.comments.objects;

public interface CommentPage {
    void open();
    void newComment();
    CommentActions getCommentAction();
    CommentTable getCurrentComments();
    CommentTable getCommentsFrom(int page);
    BCommentManagerNew getCommentManagerNew();

    BCommentManagerDuplicate getCommentManagerDuplicate();
    Pagination getPagination();
}
