package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrameWithTextField;

    @FindBy(xpath = "//p")
    public WebElement textField;
}
