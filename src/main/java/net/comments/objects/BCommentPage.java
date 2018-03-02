package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentPage implements CommentPage {
    private final WebDriver driver;

    public BCommentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get("http://commentssprintone.azurewebsites.net");
    }

    public void newComment() {
        this.driver.findElement(By.xpath("//*[@id=\"newbutton\"]")).click();
    }

    public CommentActions getCommentAction() {
        return new BCommentActions(driver);
    }

    public CommentTable getCurrentComments() {
        return new BCommentTable(driver);
    }

    public CommentTable getCommentsFrom(int page) {
        throw new UnsupportedOperationException("Please implement");
    }

    public Pagination getPagination() {
        return new Pagination(driver);
    }

    public int getCommentPageSize() {
        throw new UnsupportedOperationException("Please implement");
    }

    public BCommentManagerNew getCommentManagerNew() {
        return new BCommentManagerNew(driver);
    }

    public BCommentManagerDuplicate getCommentManagerDuplicate() {
        return new BCommentManagerDuplicate(driver);
    }

    public BCommentManagerEdit getCommentManagerEdit() {
        return new BCommentManagerEdit(driver);
    }
}
