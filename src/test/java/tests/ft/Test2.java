package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.Comment;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

public class Test2 extends BaseDriver {
    private final CommentPage page;

    Test2() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        int commentNumber = 5;
        page.getCurrentComments().selectComment(commentNumber);
        String oldCommentText = page.getCurrentComments().getCommentText(commentNumber);
        page.getCommentAction().duplicate();
        String newCommentNumber = "122";
        page.getCommentModifier().fillCommentNumber(newCommentNumber);
        page.getCommentManager().saveAndReturn();
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment" + newCommentNumber + " is not present", comment.getCommentNumber().contentEquals(newCommentNumber));
            MatcherAssert.assertThat("Comment does not contain Copy of " + oldCommentText, comment.getCommentText().contentEquals("Copy of " + oldCommentText));
        }
    }
}
