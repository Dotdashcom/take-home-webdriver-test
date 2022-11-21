package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DynamicPage extends BasePage {

    WebDriver driver;

    public DynamicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='content']/div[@class='row']")
    public List<WebElement> rows;

    public void assertRowsHasChanged() {
        for (WebElement row : rows) {
            driver.navigate().refresh();
            Assert.assertFalse(elementIsDisplayed(row));
            driver.navigate().refresh();
            Assert.assertFalse(elementIsDisplayed(row));
        }
    }
}
