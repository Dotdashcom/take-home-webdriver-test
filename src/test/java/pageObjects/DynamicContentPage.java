package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

import java.util.List;

public class DynamicContentPage extends BaseClass {

    public DynamicContentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Dynamic Content']")
    public WebElement dynamicContentPageHeader;

    @FindBy(xpath = "//div[@class='large-2 columns']/img")
    public List<WebElement> dynamicContentImages;

    @FindBy(xpath = "//div[@class='large-10 columns']")
    public List<WebElement> dynamicContentDiv;
}
