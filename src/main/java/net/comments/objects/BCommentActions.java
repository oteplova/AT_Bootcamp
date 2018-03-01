package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentActions implements CommentActions {
    private final WebDriver driver;

    public BCommentActions(WebDriver driver) {
        this.driver = driver;
    }

    public void duplicate() {
        this.driver.findElement(By.xpath("//*[@value=\"Duplicate...\"]")).click();
    }

    public void edit(String comments) {
        throw new UnsupportedOperationException("Please implement");
    }

    public void delete() {
        this.driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
    }
}
