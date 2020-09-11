package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'JavaScript error')]")
    WebElement jsErrorMessage;

    public JavaScriptErrorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testJavaScriptError(WebDriver driver) {
        boolean isErrorPresent = false;
        if (isElementPresent(driver, jsErrorMessage )) {
            isErrorPresent = true;
        }
        return isErrorPresent;
    }
}
