package tests.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagination {
    private final WebDriver driver;

    public Pagination(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String pageNumber) {
        driver.findElement(By.linkText(pageNumber)).click();
    }

    public void navigateToNextPage() {
        driver.findElement(By.linkText(">")).click();
    }

    public void navigateToPreviousPage() {
        driver.findElement(By.linkText("<")).click();
    }

}
