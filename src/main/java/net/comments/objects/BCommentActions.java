package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentActions implements CommentActions {
    private final WebDriver driver;

    public BCommentActions(WebDriver driver) {
        this.driver = driver;
    }

    public void duplicate(String commentNumber) {
        BCommentManagerDuplicate commentDuplicate = new BCommentManagerDuplicate(driver);
        this.driver.findElement(By.xpath("//*[@value=\"Duplicate...\"]")).click();
        String commentText = this.driver.findElement(By.xpath("//*[@id = \"Text\"]")).getText();
        String commentState;
        if (this.driver.findElement(By.xpath("//*[@id = \"Active\"]")).isSelected()) {
            commentState = "active";
        } else {
            commentState = "inactive";
        }
        //  String category = this.driver.findElement(By.xpath("//*[@id = \"selectedCategories\"//span]")).getText();
        commentDuplicate.saveAndReturn(commentNumber, commentText, commentState, "Cat0");
    }

    public void edit(String comments) {
        throw new UnsupportedOperationException("Please implement");
    }

    public void delete() {
        this.driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        this.driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
    }
}
