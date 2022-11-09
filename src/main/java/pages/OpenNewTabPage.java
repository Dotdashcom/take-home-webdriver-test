package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class OpenNewTabPage {

    private final By header = By.xpath("//h3[text()='Opening a new window']");
    private final By windowButton = By.xpath("//*[@id='content']/div/a");
    private final By windowHeader = By.xpath("//div[@class='example']/h3");

    public OpenNewTabPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/windows");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public void openInNewTabTest() {

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilitiesManager.FindElement(windowButton).click();
        for (String winHandle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(winHandle);
        }
        String newWindowText = UtilitiesManager.FindElement(windowHeader).getText();
        System.out.println(newWindowText);
        Assert.assertTrue(newWindowText.contains("New Window"), "window is not switched");
    }
}
