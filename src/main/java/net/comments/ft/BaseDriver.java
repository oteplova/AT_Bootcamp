package net.comments.ft;

import net.comments.selenium.CommentsDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseDriver {
    protected CommentsDriver driver;

    public BaseDriver() {
        this.driver = new CommentsDriver();
    }

    @BeforeMethod
    public void createDriver() {
        this.driver.defineDriver();
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }
}
