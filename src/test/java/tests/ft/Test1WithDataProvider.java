package tests.ft;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

/**
 * This AT covers Tests #18, #19, #20, #21
 */

@Epic("Test comments app")
@Feature("Smoke Tests")
public class Test1WithDataProvider extends BaseDriver {
    private final CommentPage page;

    Test1WithDataProvider() {
        this.page = new BCommentPage(this.driver);
    }

    @Test(description = "Test1 - Create new comments (with data providers)", dataProvider = "testData")
    @Story("Add/Edit comments")
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
                {"Test Latin characters"},
                {"Проверка символов Кириллицы"},
                {"12456447"},
                {"âãäåçèéêëìíîðñò"},
        };
    }
}
