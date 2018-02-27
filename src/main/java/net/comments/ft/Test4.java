package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;

    public Test4() {
        super();
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        CommentTable commentTable = page.getCurrentComments();
        String commentNumber = "1";
        commentTable.selectComment(commentNumber);
        page.getCommentAction().delete();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", !comment.getCommentNumber().contentEquals(commentNumber));
        }
    }
}
