package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import org.testng.annotations.Test;

public class Test6 extends BaseDriver {
    private final CommentPage page;

    Test6() {
        this.page = new BCommentPage(driver);
    }

    @Test
    public void test() {
        page.open();
        int commentNumber = 7;
        page.getCurrentComments().selectComment(commentNumber);
        page.getCommentAction().activate();
    }


}
