package tests.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectComment(int commentNumber) {
        this.driver.findElement(By.xpath(String.format("//*[@name = \"SelectedId\" and @value = \"%s\"]", commentNumber + 1))).click();
    }

    public String getCommentText(int commentNumber) {
        return this.driver.findElement(By.xpath(String.format("//*[@name = \"SelectedId\" and @value =\"%s\" ]/../../td[3]", commentNumber + 1))).getText();
    }

    public String getCommentState(int commentNumber) {
        String state = this.driver.findElement(By.xpath(String.format("//*[@name = \"SelectedId\" and @value =\"%s\" ]/../../td[4]", commentNumber + 1))).getText();
        if (state.equals("")) {
            return "active";
        } else {
            return "inactive";
        }
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

    public void selectComments(int[] commentNumbers) {
        for (int commentNumber : commentNumbers) {
            this.selectComment(commentNumber);
        }
    }

}
