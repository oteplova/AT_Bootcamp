package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.CommentPage;

public class TestTextFieldValidation extends BaseDriver {
    private final CommentPage page;

    TestTextFieldValidation() {
        this.page = new BCommentPage(this.driver);
    }

    @Test(dataProvider = "testData")
    public void test(String commentText, String error) {
        page.open();
        page.newComment();
        String commentNumber = "111";
        page.getCommentModifier().fillCommentNumber(commentNumber);
        page.getCommentModifier().fillCommentText(commentText);
        page.getCommentModifier().changeCommentActivationState("active");
        String categoryName = "Cat0";
        page.getCommentModifier().addCategory(categoryName);
        page.getCommentManager().saveAndReturn();
        MatcherAssert.assertThat("Error is not shown", page.getCommentError().checkTextValidation());
        MatcherAssert.assertThat("Error text is invalid", page.getCommentError().getErrorTest().equals(error));
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"#@%^", "The Comment Text field should contain alphanumeric characters only"},
                {"dsfsdfdfdsfgd ", "The Comment Text field should contain alphanumeric characters only"},
                {"fdsfsd fdfdsfgd", "The Comment Text field should contain alphanumeric characters only"},
                {" dsfsdfdfdsfgd ", "The Comment Text field should contain alphanumeric characters only"},
                {"(-250)", "The Comment Text field should contain alphanumeric characters only"},
                {"0.0001", "The Comment Text field should contain alphanumeric characters only"},
                {"0,0001", "The Comment Text field should contain alphanumeric characters only"},
                {"", "The Comment Text field is required."},
                {"XSS \"<input onclick=\"javascript:alert('xss');\">\"", "Sorry, an error occurred while processing your request."},
                {"<html></html>", "Sorry, an error occurred while processing your request."},
                {"DROP TABLE user;", "Sorry, an error occurred while processing your request."},
                {"<form action=\"http://commentssprintone.azurewebsites.net\"><input type=\"submit\"></form>", "The maximum length of Comment Text field is 50 characters"}
        };
    }
}
