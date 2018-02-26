package net.comments.ft;

import net.comments.objects.BCommentPage;
import net.comments.objects.CommentPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver {
    private final CommentPage page;

    Test1() {
        this.page = new BCommentPage(this.driver);
    }

    @Test
    public void test() {
        page.open();
        System.out.println(driver.findElements(By.xpath("//*[@class = \"webgrid\"]/tbody/tr")).size());
//        page.newComment();


    }
}
