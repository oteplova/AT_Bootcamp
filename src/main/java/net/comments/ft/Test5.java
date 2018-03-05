package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test5 extends BaseDriver {
    private final BCommentPage page;

    Test5() {
        this.page = new BCommentPage(driver);
    }

    @Test
    public void test() {
        page.open();
        CommentTable commentTable = page.getCurrentComments();
        int[] commentNumbers = {2, 5};
        page.getCurrentComments().selectComment(commentNumbers);
        page.getCommentAction().delete();
        for (int commentNumber : commentNumbers) {
            for (Comment comment : commentTable.getComments()) {
                MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentNumber)));
            }
        }
    }
}
