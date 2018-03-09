package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentTable;

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
        page.getCurrentComments().selectComments(commentNumbers);
        page.getCommentAction().delete();
        for (int commentNumber : commentNumbers) {
            for (Comment comment : commentTable.getComments()) {
                MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentNumber)));
            }
        }
    }
}
