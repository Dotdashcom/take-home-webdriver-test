package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MouseHoverPage extends BasePage {

    private final By image1 = By.xpath("//*[@id='content']/div/div[1]/img");
    private final By image2 = By.xpath("//*[@id='content']/div/div[2]/img");
    private final By image3 = By.xpath("//*[@id='content']/div/div[3]/img");

    private final By user1 = By.xpath("//*[@id='content']/div/div[1]/div[@class='figcaption']/h5");
    private final By user2 = By.xpath("//*[@id='content']/div/div[2]/div[@class='figcaption']/h5");
    private final By user3 = By.xpath("//*[@id='content']/div/div[3]/div[@class='figcaption']/h5");

    public MouseHoverPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("mouse_hover_url"));
    }

    public void mousehoverVerification() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(findElement(image1)).perform();

        Assert.assertTrue(findElement(user1).isDisplayed());

        action.moveToElement(findElement(image2)).perform();
        Assert.assertTrue(findElement(user2).isDisplayed());

        action.moveToElement(findElement(image3)).perform();
        Assert.assertTrue(findElement(user3).isDisplayed());

        Log.info("Mouse hover text validated Successfully");
    }
}
