package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CommentErrors {

    private final WebDriver driver;

    public CommentErrors(WebDriver driver) {
        this.driver = driver;
    }

    //The Comment Text field should contain alphanumeric characters only
    public boolean hasTextValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\" and contains(text(),\"The Comment Text field should contain alphanumeric characters only\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean hasValidationErrorPage() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"main\"]/*[contains(text(),\"Sorry, an error occurred while processing your request.\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //The Comment Text field is required.
    public boolean hasEmptyTextValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]/*/*/span[contains(text(),\"The Comment Text field is required.\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //The maximum length of Comment Text field is 50 characters
    public boolean hasMaxLenghtValidationError() {
        try {
            this.driver.findElement(By.xpath("//*[@id = \"errorfield\"]/*/*/span[contains(text(),\"The maximum length of Comment Text field is 50 characters\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkTextValidation(String error) {
        if (error == "The Comment Text field should contain alphanumeric characters only") {
            return this.hasTextValidationError();
        } else if (error == "Sorry, an error occurred while processing your request.") {
            return this.hasValidationErrorPage();
        } else if (error == "The Comment Text field is required.") {
            return this.hasEmptyTextValidationError();
        } else if (error == "The maximum length of Comment Text field is 50 characters") {
            return this.hasMaxLenghtValidationError();
        } else {
            return false;
        }
    }
}
