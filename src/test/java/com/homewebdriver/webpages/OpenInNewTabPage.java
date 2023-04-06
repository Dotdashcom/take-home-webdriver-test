package com.homewebdriver.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class OpenInNewTabPage {
    WebDriver driver;

    private static String NEW_TAB_URL="http://localhost:7080/windows";

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    public WebElement clickHereLink;
    public OpenInNewTabPage(WebDriver driver){
        this.driver=driver;
        driver.get(NEW_TAB_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
    public String switchToNewWindowAndGetTitle() throws InterruptedException {
        String n = Keys.chord(Keys.CONTROL,Keys.ENTER);
        clickHereLink.sendKeys(n);
        Thread.sleep(3000);
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        String newWindowTitle = driver.getTitle();
        System.out.println("New tab title: " + driver.getTitle());
        driver.switchTo().window(w.get(0));
        System.out.println("First tab title: " + driver.getTitle());
        return newWindowTitle;
    }


}
