package pageObjects;

import org.openqa.selenium.support.FindBy;
import utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BaseClass{

    public ContextMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text() = 'Context Menu']")
    public WebElement contextMenuPageHeader;

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement contextBox;
}
