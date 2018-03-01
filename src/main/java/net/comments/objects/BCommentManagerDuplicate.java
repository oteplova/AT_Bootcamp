package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentManagerDuplicate implements CommentManager {
    private final WebDriver driver;

    public BCommentManagerDuplicate(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void save() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void saveAndReturn(String number, String text, String state, String category) {
        throw new UnsupportedOperationException("Please implement");
    }

    public void saveAnReturn(String newCommentNumber) {
        this.driver.findElement(By.xpath("//*[@id = \"Number\"]")).clear();
        this.driver.findElement(By.xpath("//*[@id = \"Number\"]")).sendKeys(newCommentNumber);
        driver.findElement(By.xpath("//*[@value=\"Save & Return\"]")).click();
    }

}
