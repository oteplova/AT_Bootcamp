package net.comments.ft;

import net.comments.objects.*;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;
    private final CommentActions action;
    private final BCommentTable table;

    public Test4() {
        this.page = new BCommentPage(this.driver);
        this.action = new BCommentActions(this.driver);
        this.table = new BCommentTable(this.driver);
    }

    @Test
    public void test() {
        page.open();
        action.delete(1);
        table.setCommentsTable();


//
//        final String page = this.driver().getPageSource();
//        MatcherAssert.assertThat("Comment Text 0 is present", !page.contains("Comment Text 0"));
    }
}
