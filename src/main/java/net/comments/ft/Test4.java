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
        int commentID = 1;
        CommentTable commentTable = page.getCurrentComments();
        page.open();
        commentTable.selectComment(commentID);
        page.getCommentAction().delete();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentID + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentID)));
        }
    }
}