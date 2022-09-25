package pageObjects;

import org.openqa.selenium.support.FindBy;
import utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CheckBoxPage extends BaseClass{

    public CheckBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;
}
