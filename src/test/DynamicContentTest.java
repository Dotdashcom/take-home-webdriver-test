package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class DynamicContentTest extends CommonMethods {
    public static void main(String[]args) throws InterruptedException {
        setUp("http://localhost:7080/dynamic_content");

        //refreshing the webpage 4 times and comparing the content
        for(int i =0; i<3; i++){
            WebElement content = driver.findElement(By.id("content"));
            String contentText = content.getText();
            driver.navigate().refresh();
            WebElement newContent = driver.findElement(By.id("content"));
            String newContentText = newContent.getText();
            Assert.assertFalse(contentText.equals(newContentText), "The content is not changing");
                System.out.println("The content is changing");
        }
       tearDown();
    }
}
