package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenNewTabPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement newTabLink;

    public OpenNewTabPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/windows");
        PageFactory.initElements(this.driver, this);
    }

    public void clickNewTabLink() {
        this.newTabLink.click();
    }

    public void assertNewTabOpenedContent() {
        List<String> browserTabs = new ArrayList<String>(this.driver.getWindowHandles());
        this.driver.switchTo().window(browserTabs.get(1));
        WebElement text = this.driver.findElement(By.xpath("/html/body/div/h3"));
        Assert.assertEquals("New Window",text.getText());
    }

}
