package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

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
        int commentNumber = 1;
        commentTable.selectComment(commentNumber);
        page.getCommentAction().delete();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentNumber)));
        }
    }
}
