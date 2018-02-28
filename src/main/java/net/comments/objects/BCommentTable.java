package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectComment(int commentsNumber) {
        this.driver.findElements(By.name("SelectedId")).get(commentsNumber).click();
    }

    public List<Comment> getComments() {
        List<Comment> commentsList = new ArrayList<Comment>();
        int commentsCount = driver.findElements(By.xpath("//*[@class = \"webgrid\"]/tbody/tr")).size();
        for (int i = 1; i <= commentsCount; i++) {
            String commentNumber = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[2]")).getText();
            String commentText = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[3]")).getText();
            String commentActivation = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[4]")).getText();
            if (commentActivation.equals("")) {
                commentActivation = "active";
            }
            String commentCategories = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[5]")).getText();
            commentsList.add(new Comment(commentNumber, commentText, commentActivation, commentCategories));
        }
        return commentsList;
    }
}
