package tests.ft;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

@Epic("Test comments app")
@Feature("Smoke Tests")
public class Test6 extends BaseDriver {
    private final CommentPage page;

    Test6() {
        this.page = new BCommentPage(driver);
    }

    @Test(description = "Activate comment")
    @Story("Activate/Inactivate comments")
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
