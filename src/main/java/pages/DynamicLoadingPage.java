package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class DynamicLoadingPage {

    private final By header = By.xpath("//h3[text()='Dynamically Loaded Page Elements']");
    private final By startButton = By.xpath("//*[@id='start']/button");
    private final By finish = By.xpath("//*[contains(@id,'finish')]/h4");

    public DynamicLoadingPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/dynamic_loading/2");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String dynamicLoading() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilitiesManager.FindElement(startButton).click();
        UtilitiesManager.ExpectedConditions(finish, "DISPLAYED");
        return UtilitiesManager.FindElement(finish).getText();
    }

}
