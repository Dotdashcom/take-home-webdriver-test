package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class MouseHoverPage {
    private final By header = By.xpath("//h3[text()='Hovers']");

    public MouseHoverPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/hovers");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public void mouseHoverTest() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        for (int i = 1; i <= 3; i++) {
            Actions builder = new Actions(DriverManager.getDriver());
            WebElement tagElement = UtilitiesManager.FindElement(By.xpath("//*[@id='content']/div/div[" + i + "]/img"));
            builder.moveToElement(tagElement).build().perform();

            String image = UtilitiesManager.FindElement(By.xpath("//*[@id='content']/div/div[" + i + "]/div/h5")).getText();
            Assert.assertTrue(image.contains("name: user" + i), "user info is not present");
        }
    }
}
