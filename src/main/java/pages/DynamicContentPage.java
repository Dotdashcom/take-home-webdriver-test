package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class DynamicContentPage {
    private final By header = By.xpath("//h3[text()='Dynamic Content']");
    private final By imageSource = By.xpath("//*[@id='content']//img");

    public DynamicContentPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/dynamic_content?with_content=static");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }


    public boolean dynamicRefresh() {
        boolean result = false;
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String image = UtilitiesManager.FindElement(imageSource).getAttribute("src");
        DriverManager.getDriver().navigate().refresh();
        for (WebElement ele : UtilitiesManager.FindElements(imageSource)) {
            String src = ele.getAttribute("src");
            if (image.equalsIgnoreCase(src)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
