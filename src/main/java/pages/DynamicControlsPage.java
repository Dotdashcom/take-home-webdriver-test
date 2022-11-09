package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

public class DynamicControlsPage {
    private final By header = By.xpath("//h4[text()='Dynamic Controls']");
    private final By checkboxButton = By.xpath("//*[@id='checkbox-example']/button");
    private final By checkbox = By.id("checkbox");
    private final By message = By.id("message");
    private final By checkboxBack = By.xpath("//*[@id='checkbox-example']/div[1]");
    private final By inputBox = By.xpath("//*[contains(@id,'input-example')]/button");

    public DynamicControlsPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/dynamic_controls");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String dynamicRefreshWithRemoveCheckbox() {
        UtilitiesManager.FindElement(checkboxButton).click();
        UtilitiesManager.ExpectedConditions(checkbox, "INVISIBLE");
        return UtilitiesManager.FindElement(message).getText();
    }

    public String dynamicRefreshWithCheckboxBack() throws InterruptedException {

        UtilitiesManager.FindElement(checkboxButton).click();
        Thread.sleep(5000);
        UtilitiesManager.ExpectedConditions(checkboxBack, "DISPLAYED");
        return UtilitiesManager.FindElement(message).getText();
    }

    public String dynamicRefreshTestWithEnableButton() {

        UtilitiesManager.FindElement(inputBox).click();
        UtilitiesManager.ExpectedConditions(message, "DISPLAYED");
        return UtilitiesManager.FindElement(message).getText();
    }

    public String dynamicRefreshTestWithDisableButton() {

        UtilitiesManager.FindElement(inputBox).click();
        UtilitiesManager.ExpectedConditions(message, "DISPLAYED");

        return UtilitiesManager.FindElement(message).getText();

    }

}
