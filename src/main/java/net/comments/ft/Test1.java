package net.comments.ft;

import net.comments.objects.BCommentActions;
import net.comments.objects.BCommentPage;
import net.comments.objects.CommentActions;
import net.comments.objects.CommentPage;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver {
    private final CommentPage page;
    private final CommentActions action;

    Test1() {
        this.page = new BCommentPage(this.driver);
        this.action = new BCommentActions(this.driver);
    }

    @Test
    public void test() {
        page.open();
        page.newComment();

    }
}
