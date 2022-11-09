package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class iFramePage {

    private final By header = By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']");
    private final By alertLink = By.xpath("/html/body/div[4]/div/div");
    private final By entertext = By.xpath("//*[@id='tinymce']/p");

    public iFramePage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/iframe");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String frameTest() {

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilitiesManager.FindElement(alertLink).click();
        DriverManager.getDriver().switchTo().frame("mce_0_ifr");
        UtilitiesManager.FindElement(entertext).sendKeys("Type into Iframe");
        return UtilitiesManager.FindElement(entertext).getText();
    }
}
