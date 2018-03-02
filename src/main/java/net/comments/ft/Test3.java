package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.Comment;
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
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is not present", comment.getCommentNumber().contentEquals(newNumber));
            MatcherAssert.assertThat("Comment Text " + commentNumber + "  does not contain " + newText, comment.getCommentText().contentEquals(newText));
//            MatcherAssert.assertThat("Comment Text " + commentNumber + " is not in" + newState +" state", !comment.getCommentState().contentEquals(newState));
            MatcherAssert.assertThat("Comment Text " + commentNumber + " does not contain selected category", comment.getCommentCategories().contentEquals(newCategoryNumber));
        }


    }
}
