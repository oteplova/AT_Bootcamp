package tests.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class CommentsDriver implements WebDriver {
    private final WebDriver[] driver = new WebDriver[1];

    public WebDriver getDriver() {
        return this.driver[0];
    }

    public void defineDriver(WebDriver webDriver) {
        this.driver[0] = webDriver;
    }

    /**
     * Firefox will be used as a default driver
     */
    public void defineDriver() {
        this.driver[0] = new FirefoxDriver();
    }

    public void get(String s) {
        this.getDriver().get(s);
    }

    public String getCurrentUrl() {
        return this.getDriver().getCurrentUrl();
    }

    public String getTitle() {
        return this.getDriver().getTitle();
    }

    public List<WebElement> findElements(By by) {
        return this.getDriver().findElements(by);
    }

    public WebElement findElement(By by) {
        return this.getDriver().findElement(by);
    }

    public String getPageSource() {
        return this.getDriver().getPageSource();
    }

    public void close() {
        this.getDriver().close();
    }

    public void quit() {
        this.getDriver().quit();
    }

    public Set<String> getWindowHandles() {
        return this.getDriver().getWindowHandles();
    }

    public String getWindowHandle() {
        return this.getDriver().getWindowHandle();
    }

    public TargetLocator switchTo() {
        return this.getDriver().switchTo();
    }

    public Navigation navigate() {
        return this.getDriver().navigate();
    }

    public Options manage() {
        return this.getDriver().manage();
    }
}
