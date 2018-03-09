package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

public class Test6 extends BaseDriver {
    private final CommentPage page;

    Test6() {
        this.page = new BCommentPage(driver);
    }

    @Test
    public void test() {
        page.open();
        int commentNumber = 7;
        page.getCurrentComments().selectComment(commentNumber);
        page.getCommentAction().activate();
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            if (comment.getCommentNumber() == Integer.toString(commentNumber)) {
                MatcherAssert.assertThat("Comment is not activated", comment.getCommentActivation().equals("active"));
            }
        }
    }
}
