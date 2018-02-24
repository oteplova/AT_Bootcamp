package net.comments.ft;

import net.comments.objects.*;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;
    private final CommentActions action;
    private final BCommentTable table;

    public Test4() {
        super();
        this.page = new BCommentPage(this.driver);
        this.action = new BCommentActions(this.driver);
        this.table = new BCommentTable(this.driver);
    }

    @Test
    public void test() {
        int commentID = 1;
        page.open();
        action.delete(commentID);
        table.fillTable();
        for (Comment comment : table.getTableComments()) {
            MatcherAssert.assertThat("Comment Text " + commentID + " is present", !comment.getCommentNumber().contentEquals(String.valueOf(commentID)));
        }
    }
}
