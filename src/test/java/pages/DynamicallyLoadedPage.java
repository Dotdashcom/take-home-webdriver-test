package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicallyLoadedPage {

    public DynamicallyLoadedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h3")
    public WebElement header;

    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startButton;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement message;

}
