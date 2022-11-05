package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_09_DynamicLoading_Page {
    public TC_09_DynamicLoading_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Dynamic Loading")
    public WebElement dynamicLoadingLink;

    @FindBy(partialLinkText =  "Example 1: Element on page that is hidden")
    public WebElement example1;

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    public WebElement startButton;

    @FindBy(xpath = "//*[(text()='Hello World!')]")
    public WebElement helloWorld;
}
