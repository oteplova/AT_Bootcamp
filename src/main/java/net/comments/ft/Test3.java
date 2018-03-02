package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import net.comments.objects.CommentTable;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test3 extends BaseDriver {
    private final CommentPage page;

    Test3() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        int commentNumber = 1;
        page.getCurrentComments().selectComment(commentNumber);
        String oldState = page.getCurrentComments().getStateSelectedComment(commentNumber);
        page.getCommentAction().edit();
        String newNumber = "45";
        String newText = "Edited Comment Text " + commentNumber;
        String newState = null;
        if (oldState.equals("active")) {
            newState = "inactive";
        } else if (oldState.equals("inactive")) {
            newState = "active";
        }
        String newCategoryNumber = "Cat1";
        page.getCommentManagerEdit().saveAndReturn(newNumber, newText, newState, newCategoryNumber);
        CommentTable commentTable = page.getCurrentComments();

        long foundCommentNumber = commentTable.getComments().stream().filter(comment -> comment.getCommentText().contentEquals(newNumber)).count();
        MatcherAssert.assertThat("Comment with number " + commentNumber + " is not present", foundCommentNumber == 1);

        long foundCommentText = commentTable.getComments().stream().filter(comment -> comment.getCommentText().contentEquals(newText)).count();
        MatcherAssert.assertThat("Comment Text does not contains" + newText, foundCommentText == 1);



    }
}
