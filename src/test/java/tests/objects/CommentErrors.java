package tests.objects;
/*

 */

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CommentErrors {

    private final WebDriver driver;

    public CommentErrors(WebDriver driver) {
        this.driver = driver;
    }

    //The Comment Text field should contain alphanumeric characters only
    @Step("Check error after entering not alphanumeric characters")
    public boolean hasAlphanumericTextValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\" and contains(text(),\"The Comment Text field should contain alphanumeric characters only\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Check error after entering invalid data")
    public boolean hasValidationErrorPage() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"main\"]/*[contains(text(),\"Sorry, an error occurred while processing your request.\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //The Comment Text field is required.
    @Step("Check error after leaving field empty")
    public boolean hasEmptyTextValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]/*/*/span[contains(text(),\"The Comment Text field is required.\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //The maximum length of Comment Text field is 50 characters
    @Step("Check error after entering more than 50 characters")
    public boolean hasMaxLenghtValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]/*/*/span[contains(text(),\"The maximum length of Comment Text field is 50 characters\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Check the appearance of error")
    public boolean checkTextValidation() {
        return hasAlphanumericTextValidationError() || hasValidationErrorPage() || hasEmptyTextValidationError() || hasMaxLenghtValidationError();
    }

    @Step("Get error text")
    public String getErrorText() {
        if (hasAlphanumericTextValidationError() || hasEmptyTextValidationError() || hasMaxLenghtValidationError()) {
            return this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]")).getText();
        } else if (hasValidationErrorPage()) {
            return this.driver.findElement(By.xpath("//*[@id = \"main\"]")).getText();
        } else {
            return "  ";
        }
    }
}
