package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class DynamicLoadingPage {
    public DynamicLoadingPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Example 1: Element on page that is hidden']")
    public WebElement example1;

    @FindBy(xpath = "//*[text()='Example 2: Element rendered after the fact']")
    public WebElement example2;

    @FindBy(xpath = "//*[text()='Start']")
    public WebElement startBtn;

    @FindBy(id = "finish")
    public WebElement HelloWorld;
}
