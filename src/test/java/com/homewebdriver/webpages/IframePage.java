package com.homewebdriver.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IframePage {
    WebDriver driver;

    private static String IFRAME_URL="http://localhost:7080/iframe";

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//div[@class='tox-icon']")
    public WebElement closeIconInPopUpMessage;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement textArea;



    public IframePage(WebDriver driver){
        this.driver=driver;
        driver.get(IFRAME_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickCloseIconInPopUpMessage() {
       closeIconInPopUpMessage.click();
    }
    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public void enterTextInFrame() {
       textArea.clear();
       textArea.sendKeys("Hello World");
    }

}
