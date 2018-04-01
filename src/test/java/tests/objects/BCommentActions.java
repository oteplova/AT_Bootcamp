package tests.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentActions implements CommentActions {
    private final WebDriver driver;

    public BCommentActions(WebDriver driver) {
        this.driver = driver;
    }

    @Step("click 'Duplicate...' link")
    public void duplicate() {
        this.driver.findElement(By.xpath("//*[@value=\"Duplicate...\"]")).click();
    }

    @Step("click 'Edit...' link")
    public void edit() {
        this.driver.findElement(By.xpath("//*[@value=\"Edit..\"]")).click();
    }

    @Step("click 'Delete' link and confirm the deletion")
    public void delete() {
        this.driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
    }

    @Step("click 'Activate' item from 'Action' drop-down")
    public void activate() {
        this.driver.findElement(By.xpath("//*[@id = \"commandSelect\"]/option[@value = \"Activate\"]")).click();
    }
}
