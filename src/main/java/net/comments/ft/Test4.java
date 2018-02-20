package net.comments.ft;

import net.comments.objects.BCommentActions;
import net.comments.objects.BCommentPage;
import net.comments.objects.CommentActions;
import net.comments.objects.CommentPage;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;
    private final CommentActions action;

    public Test4() {
        this.page = new BCommentPage(this.driver);
        this.action = new BCommentActions(this.driver);
    }

    @Test
    public void test() {
        page.open();
        action.delete(1);
//
//        final String page = this.driver().getPageSource();
//        MatcherAssert.assertThat("Comment Text 0 is present", !page.contains("Comment Text 0"));
    }
}
