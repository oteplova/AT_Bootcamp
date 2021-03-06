package tests.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentPage implements CommentPage {
    private final WebDriver driver;

    public BCommentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open 'Comments page'")
    public void open() {
        this.driver.get("http://commentssprintone.azurewebsites.net");
    }

    @Step("Click 'New' link")
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

    public BCommentManager getCommentManager() {
        return new BCommentManager(driver);
    }

    public CommentModifier getCommentModifier() {
        return new CommentModifier(driver);
    }

    public CommentErrors getCommentError() {
        return new CommentErrors(driver);
    }

}
