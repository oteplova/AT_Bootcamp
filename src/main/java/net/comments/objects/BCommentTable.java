package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;
    private List<Comment> commentsList;

    public BCommentTable(WebDriver driver) {
        this.driver = driver;
        commentsList = new ArrayList<Comment>();
    }

    public void selectComment(int commentsNumber) {
        this.driver.findElements(By.name("SelectedId")).get(commentsNumber).click();
    }

    public List<Comment> getComments() {
        String commentNumber;
        String commentText;
        String commentActivation;
        String commentCategories;
        for (int i = 1; i <= 10; i++) {
            commentNumber = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[2]")).getText();
            commentText = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[3]")).getText();
            commentActivation = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[4]")).getText();
            if (commentActivation.equals("")) {
                commentActivation = "active";
            }
            commentCategories = this.driver.findElement(By.xpath("//*[@class = \"webgrid\"]//tr[" + i + "]//td[5]")).getText();
            this.commentsList.add(new Comment(commentNumber, commentText, commentActivation, commentCategories));
        }
        return commentsList;
    }
}
