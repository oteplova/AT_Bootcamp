package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test6 extends BaseDriver {
    private final CommentPage page;

    Test6() {
        this.page = new BCommentPage(driver);
    }

    @Test
    public void test() {
        page.open();
        int[] commentNumber = {7};
        page.getCurrentComments().selectComment(commentNumber);
        page.getCommentAction().activate();
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            if (comment.getCommentNumber() == Integer.toString(commentNumber[0])) {
                MatcherAssert.assertThat("Comment is not activated", comment.getCommentActivation().equals("active"));
            }
        }
    }
}
