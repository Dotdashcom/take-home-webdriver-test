package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.List;

public class Test14MouseHover extends GenericTest {

    @Test
    public void Test14MouseHover() {
        String url = "http://localhost:7080/hovers";
        driver.get(url);

        //store all figures in list
        By figureXpath = By.xpath("//div[@id='content']/descendant::div[@class='figure']");
        List<WebElement> figures = driver.findElements(figureXpath);

        //array of figure caption keys
        String[] figureCaptionKeys = {
            "name: user1",
            "name: user2",
            "name: user3"
        };

        //check that figureCaptionKeys and figures are parallel arrays
        Assert.assertEquals(figureCaptionKeys.length,figures.size());

        //loop through each figure, hover over it, and check that correct text appears for each caption
        Actions action = new Actions(driver);
        for(int i = 0; i < figures.size(); i++) {
            action.moveToElement(figures.get(i)).perform();
            String figureCaptionText = figures.get(i).findElement(By.xpath("descendant::h5")).getText();
            Assert.assertEquals(figureCaptionText,figureCaptionKeys[i]);
        }
    }

}