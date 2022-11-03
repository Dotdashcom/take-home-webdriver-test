package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class OpenNewTabPage extends BasePage {

    public OpenNewTabPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/windows");
    }

    @FindBy(xpath = "//a[text()='Click Here']")
    private WebElement clickHereBtn;


    public void clickClickHereBtn(){
        clickHereBtn.click();

    }

    public void assertTextInNewTab(String message){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement textInNewTab = driver.findElement(By.cssSelector("div[class='example']"));

        Assert.assertEquals(message, textInNewTab.getText());
    }

}
