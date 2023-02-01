package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class MouseHoverPage extends BasePage {
    public MouseHoverPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (xpath = "//div[@class='figure']")
    private List<WebElement> avatars;

    @FindBy (xpath = "//div[@class='figcaption']//h5")
    private List<WebElement> avatarsNames;

    @FindBy (xpath = "//div[@class='figcaption']//a")
    private List<WebElement> avatarsLinks;

    public void verifyMouseHover(){
        Actions actions = new Actions(driver);
        for (int i = 0; i < avatars.size(); i++) {
            actions.moveToElement(avatars.get(i)).build().perform();
            softAssert.assertTrue(avatarsNames.get(i).isDisplayed(),"Name of " + (i+1) + " avatar is not displayed");
            softAssert.assertTrue(avatarsLinks.get(i).isDisplayed(),"Link of " + (i+1) + " avatar is not displayed");
            softAssert.assertTrue(avatarsLinks.get(i).isEnabled(),"Link of " + (i+1) + " avatar is not enabled");
        }
}


}
