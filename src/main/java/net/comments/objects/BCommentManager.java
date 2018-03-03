package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentManager implements CommentManager {
    private final WebDriver driver;

    public BCommentManager(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void save() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void saveAndReturn() {
        driver.findElement(By.xpath("//*[@value=\"Save & Return\"]")).click();
    }
}
