package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DyLoader {
    public DyLoader() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startBtn;
    @FindBy(id = "loading")
    public WebElement loadBar;
    @FindBy(xpath = "//h4[.='Hello World!']")
    public WebElement helloWorld;

}
