package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class JavaScriptAlertsPage {

    private final By header = By.xpath("//h3[text()='JavaScript Alerts']");
    private final By jsAlert = By.xpath("//*[@id='content']/div/ul/li[1]/button");
    private final By jsConfirm = By.xpath("//*[@id='content']/div/ul/li[2]/button");
    private final By jsPrompt = By.xpath("//*[@id='content']/div/ul/li[3]/button");
    private final By result = By.xpath("//*[@id='result']");


    public JavaScriptAlertsPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/javascript_alerts");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public void javaScriptAlertTest() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilitiesManager.FindElement(jsAlert).click();
        String alertText = DriverManager.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("I am a JS Alert"), "Alert text is not present");
        DriverManager.getDriver().switchTo().alert().accept();

        UtilitiesManager.FindElement(jsConfirm).click();
        String alertTextJSConfirm = DriverManager.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertTextJSConfirm.contains("I am a JS Confirm"), "Alert text is not present");
        DriverManager.getDriver().switchTo().alert().accept();

        UtilitiesManager.FindElement(jsPrompt).click();
        String alertTextJSPrompt = DriverManager.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertTextJSPrompt.contains("I am a JS prompt"), "Alert text is not present");
        String text = "Hello JS Prompt";
        DriverManager.getDriver().switchTo().alert().sendKeys(text);
        DriverManager.getDriver().switchTo().alert().accept();

        String verifiedEnteredText = UtilitiesManager.FindElement(result).getText();
        Assert.assertTrue(verifiedEnteredText.contains(text), "Text is not entered");
    }
}
