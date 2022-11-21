package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDownPage extends BasePage {

    WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    public WebElement dropDown;

    public void selectOnDropDownByText(String text) {
        Select options = new Select(dropDown);
        options.selectByVisibleText(text);
    }

    public void assertOptionIsSelectedByText(String text) {
        Select options = new Select(dropDown);
        List<WebElement> selectedOptions = options.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            Assert.assertEquals(text, option.getText());
        }
    }
}
