package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JavaScriptAlertsPage extends Functions {


    @FindBy(xpath = "//button[starts-with(@onclick,'js')]")
    public List<WebElement> alerts;

    @FindBy(id = "result")
    public WebElement resultMessage;




    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public JavaScriptAlertsPage() {

        PageFactory.initElements(driver, this);

    }


}
