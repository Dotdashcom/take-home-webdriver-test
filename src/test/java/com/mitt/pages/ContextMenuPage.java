package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ContextMenuPage extends BasePage {

    private final By contextMenu_xpath = By.xpath("//*[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("contextMenu_url"));
    }

    public void rightClickContextMenu(){

        Log.info("right clicking context Menu");

        Actions actions = new Actions(getDriver());

        Log.info("verify contect menu presnt");
        Assert.assertEquals(true, isElementPresent(contextMenu_xpath));

        Log.info("performing right click");
        actions.contextClick(getDriver().findElement(contextMenu_xpath)).perform();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void verifyAlertMenuText(){

        String windowHandle= getDriver().getWindowHandle();
        Log.info("window handles alert = "+ windowHandle);
        Log.info("switching alert");
        Alert alert = getDriver().switchTo().alert();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualAlertText = alert.getText();

        Log.info("Alert text = "+actualAlertText);
        String expectedText = "You selected a context menu";

        Assert.assertEquals(actualAlertText, expectedText, "Alert title is not same");
        alert.accept();
        getDriver().switchTo().window(windowHandle);
        Log.info("Text is matching for alert");
    }

}
