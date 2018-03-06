package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test22 extends BaseDriver {
    private final CommentPage page;

    Test22() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        page.newComment();
        String commentNumber = "111";
        page.getCommentModifier().fillCommentNumber(commentNumber);
        String commentText = "test #";
        page.getCommentModifier().fillCommentText(commentText);
        page.getCommentModifier().changeCommentActivationState("active");
        String categoryName = "Cat0";
        page.getCommentModifier().addCategory(categoryName);
        page.getCommentManager().saveAndReturn();
        MatcherAssert.assertThat("Error is not shown", page.getCommentError().hasErrorForCommentText());
    }
}
