package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This AT covers Tests #18, #19, #20, #21
 */

public class Test1WithDataProvider extends BaseDriver {
    private final CommentPage page;

    Test1WithDataProvider() {
        this.page = new BCommentPage(this.driver);
    }

    @Test(dataProvider = "testData")
    public void test(String commentText) {
        page.open();
        page.newComment();
        String commentNumber = "111";
        page.getCommentModifier().fillCommentNumber(commentNumber);
        page.getCommentModifier().fillCommentText(commentText);
        page.getCommentModifier().changeCommentActivationState("active");
        page.getCommentModifier().addCategory("Cat3");
        page.getCommentManager().saveAndReturn();
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            if (comment.getCommentNumber() == commentNumber) {
                MatcherAssert.assertThat("Comment does not contain " + commentText, comment.getCommentText().equals(commentText));
            }
        }
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"Test latin characters"},
                {"Проверка символов кирилицы"},
                {"12456447"},
                {"âãäåçèéêëìíîðñò"},
        };
    }
}
