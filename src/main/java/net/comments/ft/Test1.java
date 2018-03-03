package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver {
    private final CommentPage page;

    Test1() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        page.newComment();
        String commentNumber = "111";
        page.getCommentModifier().fillCommentNumber(commentNumber);
        String commentText = "Test Text";
        page.getCommentModifier().fillCommentText(commentText);
        page.getCommentModifier().changeCommentActivationState("active");
        String categoryName = "Cat0";
        page.getCommentModifier().addCategory(categoryName);
        page.getCommentManagerNew().saveAndReturn();
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", comment.getCommentNumber().contentEquals(commentNumber));
            MatcherAssert.assertThat("Comment does not contain " + commentText, comment.getCommentText().contentEquals(commentText));
        }
    }
}
