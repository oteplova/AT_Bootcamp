package tests.ft;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentTable;

@Epic("Test comments app")
@Feature("Smoke Tests")
public class Test5 extends BaseDriver {
    private final BCommentPage page;

    Test5() {
        this.page = new BCommentPage(driver);
    }

    @Test(description = "Test5 - Delete several comments")
    @Story("Delete comments")
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
