package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentManagerNew implements CommentManager {
    private final WebDriver driver;

    public BCommentManagerNew(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void save() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void saveAndReturn(String number, String text, String state, String categoryNumber) {
        driver.findElement(By.id("Text")).sendKeys(text);
        driver.findElement(By.id("Number")).sendKeys(number);
        if (state == "active" && !this.driver.findElement(By.id("Active")).isSelected()) {
            driver.findElement(By.id("//*[@id =\"Active\"]")).click();
        }
        driver.findElement(By.xpath(String.format("//*[@id = \"Categories\" and @value = \"%s\"]", categoryNumber))).click();
        driver.findElement(By.xpath("//*[@value=\">\"]")).click();
        driver.findElement(By.xpath("//*[@value=\"Save & Return\"]")).click();
    }
}
