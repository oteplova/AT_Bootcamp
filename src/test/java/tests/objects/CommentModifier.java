package tests.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommentModifier {
    private final WebDriver driver;

    public CommentModifier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill 'Number' field ")
    public void fillCommentNumber(String newCommentNumber) {
        driver.findElement(By.id("Number")).clear();
        driver.findElement(By.id("Number")).sendKeys(newCommentNumber);
    }

    @Step("Fill 'Text' field ")
    public void fillCommentText(String newCommentText) {
        driver.findElement(By.id("Text")).clear();
        driver.findElement(By.id("Text")).sendKeys(newCommentText);
    }

    @Step("Set 'Active/Inactive' state ")
    public void changeCommentActivationState(String newState) {
        if (newState.equals("active") && !driver.findElement(By.id("Active")).isSelected()) {
            driver.findElement(By.id("Active")).click();
        } else if (newState.equals("inactive") && driver.findElement(By.id("Active")).isSelected()) {
            driver.findElement(By.id("Active")).click();
        }

    }

    @Step("Add categories")
    public void addCategory(String newCategoryName) {
        int categoryListSize = driver.findElements(By.xpath("//*[@id = \"alvailablecategories\"]/*")).size();
        for (int i = 0; i < categoryListSize; i++) {
            String category = driver.findElement(By.xpath(String.format("//*[span = \"Cat%s\"]", i))).getText();
            if (category.equals(newCategoryName)) {
                driver.findElement(By.xpath(String.format("//*[span = \"Cat%s\"]/*", i))).click();
                driver.findElement(By.xpath("//*[@value=\">\"]")).click();
            }
        }

    }

    @Step("Remove all categories")
    public void removeAllCategories() {
        driver.findElement(By.xpath("//*[@value=\"<<\"]")).click();
    }
}
