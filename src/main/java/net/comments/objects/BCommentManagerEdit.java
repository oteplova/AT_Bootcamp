package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentManagerEdit implements CommentManager {
    private final WebDriver driver;

    public BCommentManagerEdit(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void save() {
        throw new UnsupportedOperationException("Please implement");
    }

    public void saveAndReturn(String newNumber, String newText, String newState, String newCategoryName) {
        driver.findElement(By.id("Text")).clear();
        driver.findElement(By.id("Text")).sendKeys(newText);
        driver.findElement(By.id("Number")).clear();
        driver.findElement(By.id("Number")).sendKeys(newNumber);
        if (newState.equals("active") && !driver.findElement(By.id("Active")).isSelected()) {
            driver.findElement(By.id("Active")).click();
        } else if (newState.equals("inactive") && driver.findElement(By.id("Active")).isSelected()) {
            driver.findElement(By.id("Active")).click();
        }
        driver.findElement(By.xpath("//*[@value=\"<<\"]")).click();

        int categoryListSize = driver.findElements(By.xpath("//*[@id = \"alvailablecategories\"]/*")).size();
        for (int i = 0; i < categoryListSize; i++) {
            String category = driver.findElement(By.xpath(String.format("//*[span = \"Cat%s\"]", i))).getText();
            if (category.equals(newCategoryName)) {
                driver.findElement(By.xpath(String.format("//*[span = \"Cat%s\"]/*", i))).click();
                driver.findElement(By.xpath("//*[@value=\">\"]")).click();
            }
        }

        driver.findElement(By.xpath("//*[@value=\"Save & Return\"]")).click();
    }
}
