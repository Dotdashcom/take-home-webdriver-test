package com.BostonBragg.TakeHomeWebDriverTest.pom;

import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    WebDriver driver;
    By jsAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    By jsConfirmButton = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    By jsPromptButton = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(String buttonName) {
        By buttonToClick = null;

        switch (buttonName) {
            case "alert" -> buttonToClick = jsAlertButton;
            case "confirm" -> buttonToClick = jsConfirmButton;
            case "prompt" -> buttonToClick = jsPromptButton;
        }

        DriverUtils.findElementWithWait(driver, buttonToClick).click();
    }
}
