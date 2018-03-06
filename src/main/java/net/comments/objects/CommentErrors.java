package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CommentErrors {

    private final WebDriver driver;

    public CommentErrors(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasErrorForCommentText() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
