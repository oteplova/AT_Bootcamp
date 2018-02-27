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
        String commentNumber = "5";
        page.getCurrentComments().selectComment(commentNumber);
        page.getCommentAction().duplicate(commentNumber);
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", comment.getCommentNumber().contentEquals(commentNumber));
        }
    }
}
