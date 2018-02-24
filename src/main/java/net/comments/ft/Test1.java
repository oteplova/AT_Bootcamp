package net.comments.ft;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
    private final WebDriver[] driver = new WebDriver[1];

    @Test
    public void test() {
        final String page;
        final String commentsText = "Test text";
        final String number = "31";

        driver().get("http://commentssprintone.azurewebsites.net");
        page = this.driver().getPageSource();
        driver().findElement(By.id("newbutton")).click();
        driver().findElement(By.id("Text")).sendKeys(commentsText);
        driver().findElement(By.id("Number")).sendKeys(number);
        driver().findElement(By.xpath("//*[@value=\"1\"]")).click();
        driver().findElement(By.xpath("//*[@value=\">\"]")).click();
        driver().findElement(By.xpath("//*[@value=\"Save & Return\"]")).click();
        driver().findElement(By.linkText("4")).click();
        MatcherAssert.assertThat("Comment is not present on the page", !page.contains(commentsText));
        String savedNumber = driver().findElement(By.xpath("//*[@id = 'main']//tr[1]//td[2]")).getText();
        MatcherAssert.assertThat("Number is not " + number, savedNumber.contains(number));
        String savedCommentsText = driver().findElement(By.xpath("//*[@id = 'main']//tr[1]//td[3]")).getText();
        MatcherAssert.assertThat("Comments text does not contain " + savedCommentsText, savedCommentsText.contains(commentsText));
        String inactivationSign = driver().findElement(By.xpath("//*[@id = 'main']//tr[1]//td[4]")).getText();
        MatcherAssert.assertThat("Inactive column contains 'tick' sign", !inactivationSign.contains("V"));
        String categoryName = driver().findElement(By.xpath("//*[@id = 'main']//tr[1]//td[5]")).getText();
        MatcherAssert.assertThat("Category column does not corresponds to saved", categoryName.contains("Cat0"));
    }

    @BeforeMethod
    public void createDriver() {
        driver[0] = new FirefoxDriver();
    }

    @AfterMethod
    public void closeDriver() {
        driver[0].close();
    }

    private WebDriver driver() {
        return this.driver[0];
    }

}
