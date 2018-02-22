package net.comments.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;
    private BComment comment;
    private List<BComment> commentsList;

    public BCommentTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectComment(int commentsNumber) {
        this.driver.findElements(By.name("SelectedId")).get(commentsNumber).click();
    }

    public void setCommentsTable() {
        String commentNumber;
        String commentText;
        String commentActivation;
        String commentCategories;

        for (int i = 0; i < 10; i++) {
            this.driver.findElements(By.xpath());
            commentNumber = "0";
            commentText = "TTTT";
            commentActivation = "V";
            commentCategories = "Cat0";
            this.comment = new BComment(commentNumber, commentText, commentActivation, commentCategories);
//            this.commentsList.add(comment);
        }

    }
}
