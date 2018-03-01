package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test2 extends BaseDriver {
    private final CommentPage page;

    Test2() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        int commentNumber = 5;
        page.getCurrentComments().selectComment(commentNumber);
        String textSelectedComment = page.getCurrentComments().getTextSelectedComment(commentNumber);
        page.getCommentAction().duplicate();
        String newCommentNumber = "122";
        page.getCommentManagerDuplicate().saveAnReturn(newCommentNumber);
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text" + newCommentNumber + " is present", comment.getCommentNumber().contentEquals(newCommentNumber));
            MatcherAssert.assertThat("Comment Text " + newCommentNumber + " is present", comment.getCommentText().contentEquals("Copy of " + textSelectedComment));
        }
    }
}
