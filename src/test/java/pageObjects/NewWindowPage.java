package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class NewWindowPage extends BaseClass {

    public NewWindowPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement newWindowPageHeader;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement clickHereLink;
}
