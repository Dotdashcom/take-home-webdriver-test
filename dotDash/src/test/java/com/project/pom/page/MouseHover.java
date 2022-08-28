package com.project.pom.page;

import com.project.pom.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover extends Base {

    By content = By.id("content");
    By figure = By.xpath("//div[@class='figure']");

    public MouseHover(WebDriver driver) {
        super(driver);
    }

    public void mouseHover(){
        if (isDisplayed(content)){
            List<WebElement> images = findElements(figure);
            Actions actions = new Actions(driver);
            String[] names = {"name: user1", "name: user2", "name: user3"};
            for (int i = 0; i < images.size(); i++){
                actions.moveToElement(images.get(i)).build().perform();
                Assert.assertEquals(names[i],images.get(i).findElement(By.xpath("descendant::h5")).getText());
            }
        }else {
            System.out.println("Mouse page was no found");
        }
    }
}
