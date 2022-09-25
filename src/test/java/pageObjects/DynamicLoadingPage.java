package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class DynamicLoadingPage extends BaseClass{

    public DynamicLoadingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Dynamically Loaded Page Elements']")
    public WebElement dynamicLoadPageHeader;

    @FindBy(xpath = "//button[text()='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement finishText;
}
