package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentActions implements CommentActions {
    private final WebDriver driver;
    private CommentTable selectedItem;

    public BCommentActions(WebDriver driver) {
        this.driver = driver;
        selectedItem = new BCommentTable(driver);
    }

    public void duplicate(String comments) {
        throw new UnsupportedOperationException("Please implement");
    }

    public void edit(String comments) {
        throw new UnsupportedOperationException("Please implement");
    }

    public void delete() {
        this.driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
    }
}
