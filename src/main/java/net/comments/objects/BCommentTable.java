package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectComment(int commentsNumber) {
        this.driver.findElements(By.name("SelectedId")).get(commentsNumber).click();
    }
}
