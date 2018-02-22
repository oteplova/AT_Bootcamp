package net.comments.ft;

import net.comments.objects.*;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;
    private final CommentActions action;
    private final BCommentTable table;
    private int commentID;

    public Test4() {
        super();
        this.page = new BCommentPage(this.driver);
        this.action = new BCommentActions(this.driver);
        this.table = new BCommentTable(this.driver);
    }

    @Test
    public void test() {
        page.open();
        commentID = 1;
        action.delete(commentID);
        table.setCommentsTable();

        for (BComment comment : table.getCommentsTable()) {
            MatcherAssert.assertThat("Comment Text " + commentID + " is present", comment.getCommentNumber().contains(String.valueOf(commentID)));
        }
    }
}
