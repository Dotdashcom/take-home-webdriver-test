package com.BostonBragg.TakeHomeWebDriverTest.pom;

import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoversPage {
    WebDriver driver;
    By imageOne = By.xpath("//*[@id=\"content\"]/div/div[1]/img");
    By imageTwo = By.xpath("//*[@id=\"content\"]/div/div[2]/img");
    By imageThree = By.xpath("//*[@id=\"content\"]/div/div[3]/img");
    By imageOneAddInfo = By.xpath("//*[@id=\"content\"]/div/div[1]/div");
    By imageTwoAddInfo = By.xpath("//*[@id=\"content\"]/div/div[2]/div");
    By imageThreeAddInfo = By.xpath("//*[@id=\"content\"]/div/div[3]/div");

    public MouseHoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverImage(int imageNum) {
        Actions action = new Actions(driver);
        By image = getImageByNum(imageNum);
        action.moveToElement(DriverUtils.findElementWithWait(driver, image)).perform();
    }

    public boolean addInfoIsVisible(int imageNum) {
        By imageAddInfo = getImageAddInfoByNum(imageNum);
        return DriverUtils.findElementWithWait(driver, imageAddInfo).isDisplayed();
    }

    private By getImageByNum(int imageNum) {
        switch (imageNum) {
              case 1 -> {
                return imageOne;
            } case 2 -> {
                return imageTwo;
            } case 3 -> {
                return imageThree;
            }
        }
        return null;
    }

    private By getImageAddInfoByNum(int imageNum) {
        switch (imageNum) {
            case 1 -> {
                return imageOneAddInfo;
            } case 2 -> {
                return imageTwoAddInfo;
            } case 3 -> {
                return imageThreeAddInfo;
            }
        }
        return null;
    }
}
