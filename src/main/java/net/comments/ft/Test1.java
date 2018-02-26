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
        page.getCommentManagerNew().saveAndReturn();
        page.getPagination().navigateTo("4");
        CommentTable commentTable = page.getCurrentComments();
        int commentNumber = 111;
        for (Comment comment : commentTable.getComments()) {
            MatcherAssert.assertThat("Comment Text " + commentNumber + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentNumber)));
        }



    }
}
