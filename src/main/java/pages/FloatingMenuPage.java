package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class FloatingMenuPage {
    private final By header = By.xpath("//h3[text()='Floating Menu']");
    private final By floatingText = By.xpath("//*[@id='menu']/ul/li[1]/a");

    public FloatingMenuPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/floating_menu");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String floatingMenuTest() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilitiesManager.jsScroller();
        return UtilitiesManager.FindElement(floatingText).getText();

    }
}
