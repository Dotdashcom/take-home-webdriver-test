package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage extends Functions {

    @FindBy(xpath = "//body[@onload='loadError()']/p")
    public WebElement jsError;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public JavaScriptErrorPage() {

        PageFactory.initElements(driver, this);

    }
}
