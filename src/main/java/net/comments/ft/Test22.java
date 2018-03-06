package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test22 extends BaseDriver {
    private final CommentPage page;

    Test22() {
        this.page = new BCommentPage(this.driver);
    }

    @Test(dataProvider = "testData")
    public void test(String commentText, String error) {
        page.open();
        page.newComment();
        String commentNumber = "111";
        page.getCommentModifier().fillCommentNumber(commentNumber);
//        String commentText = "test #";
        page.getCommentModifier().fillCommentText(commentText);
        page.getCommentModifier().changeCommentActivationState("active");
        String categoryName = "Cat0";
        page.getCommentModifier().addCategory(categoryName);
        page.getCommentManager().saveAndReturn();

        MatcherAssert.assertThat("Error is not shown", page.getCommentError().hasValidationErrorPage());

    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"test #", "The Comment Text field should contain alphanumeric characters only"},
                {"", "The Comment Text field is required."},
                {"XSS \"<input onclick=\"javascript:alert('xss');\">\"", "\"Sorry, an error occurred while processing your request.\""},
                {"Very long sting text for verifying maximum lenght of comment text", "The maximum length of Comment Text field is 50 characters"}
        };
    }
}
