package tests.ft;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import tests.objects.BCommentPage;
import tests.objects.CommentPage;
import tests.objects.CommentTable;

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
        page.getCommentAction().edit();
        String newNumber = "45";
        page.getCommentModifier().fillCommentNumber(newNumber);
        String newText = "Edited Comment Text " + commentNumber;
        page.getCommentModifier().fillCommentText(newText);
        page.getCommentModifier().changeCommentActivationState("active");
        String newCategoryName = "Cat1";
        page.getCommentModifier().removeAllCategories();
        page.getCommentModifier().addCategory(newCategoryName);
        page.getCommentManager().saveAndReturn();
        CommentTable commentTable = page.getCurrentComments();
        long foundCommentNumber = commentTable.getComments().stream().filter(comment -> comment.getCommentNumber().contentEquals(newNumber)).count();
        MatcherAssert.assertThat("Comment with number " + newNumber + " is not present", foundCommentNumber == 1);
        long foundCommentText = commentTable.getComments().stream().filter(comment -> comment.getCommentText().contentEquals(newText)).count();
        MatcherAssert.assertThat("Comment Text does not contains" + newText, foundCommentText == 1);
    }
}
