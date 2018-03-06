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

    public void edit() {
        this.driver.findElement(By.xpath("//*[@value=\"Edit..\"]")).click();
    }

    public void delete() {
        this.driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
    }

    public void activate() {
        this.driver.findElement(By.xpath("//*[@id = \"commandSelect\"]/option[@value = \"Activate\"]")).click();
    }
}
