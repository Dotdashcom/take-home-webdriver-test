package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DynamicLoadingPage {
    public DynamicLoadingPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(css = "div[class=example]>a")
    public WebElement example1;

    @FindBy(xpath = "//div[@class='example']/a[2]")
    public WebElement example2;

    @FindBy(css = "#start>button")
    public WebElement start;

    @FindBy(css = "#finish>h4")
    public WebElement helloWorld;
}
