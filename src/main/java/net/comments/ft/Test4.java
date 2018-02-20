package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import org.testng.annotations.Test;

public class Test4 extends BaseDriver {
    private final CommentPage page;

    public Test4() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        page.newComment();

//        this.driver().findElement(By.xpath("//*[@value=\"Delete\"]")).click();
//        this.driver().findElement(By.xpath("//span[text()=\"Yes\"]")).click();
//        final String page = this.driver().getPageSource();
//        MatcherAssert.assertThat("Comment Text 0 is present", !page.contains("Comment Text 0"));
    }
}
