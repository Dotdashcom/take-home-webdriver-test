package pages;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class DropdownPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"dropdown\"]")
    WebElement dropDown;

    Select dropDownOpt;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/dropdown");
        PageFactory.initElements(driver, this);
        this.dropDownOpt = new Select(this.dropDown);
    }

    public void clickDropdownElement(String optText) {
        this.dropDownOpt.selectByVisibleText(optText);
    }

    public List<WebElement> getOptions() {
        return this.dropDownOpt.getOptions();
    }

    public void assertSelectStatus(WebElement option) {
        List<WebElement> selectedOptions = this.dropDownOpt.getAllSelectedOptions();
        for (WebElement selectedOption: selectedOptions) {
            if (option.equals(selectedOption)) {
                return;
            }
        }
        Assert.fail();
    }
}
