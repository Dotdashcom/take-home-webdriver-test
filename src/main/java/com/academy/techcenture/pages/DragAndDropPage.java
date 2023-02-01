package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DragAndDropPage extends BasePage{

    public DragAndDropPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (tagName = "h3")
    private WebElement header;

    @FindBy (xpath = "//div[@id='column-a']")
    private WebElement boxLeft;

    @FindBy (xpath = "//div[@id='column-b']")
    private WebElement boxRight;

    public void dragAndDrop() throws InterruptedException {
        String textLeftElement = boxLeft.getText().trim(); //A
        String textRightElement = boxRight.getText().trim(); //B

        int x = boxRight.getLocation().x;
        int y = boxRight.getLocation().y;
        Actions actions = new Actions(driver);

        actions.moveToElement(boxLeft)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(boxLeft)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x,y)
                .moveToElement(boxRight)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform(); // B A

        softAssert.assertEquals(boxLeft.getText(), textRightElement, "Drug and Drop after 1 move left-to-right, left is not match as " + textRightElement);
        softAssert.assertEquals(boxRight.getText(), textLeftElement, "Drug and Drop after 1 move left-to-right, right is not match as " + textLeftElement);

        x = boxLeft.getLocation().x;
        y = boxLeft.getLocation().y;

        actions.moveToElement(boxRight)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(boxRight)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x,y)
                .moveToElement(boxLeft)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();

        softAssert.assertEquals(boxLeft.getText(), textLeftElement, "Drug and Drop after 2 move right-to-left, left is not match as " + textLeftElement);
        softAssert.assertEquals(boxRight.getText(), textRightElement, "Drug and Drop after 2 move right-to-left, left is not match as " + textRightElement);
    }




}

