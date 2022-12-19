package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptErrorPage extends BasePage{
    public JavaScriptErrorPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[contains(.,'This page has a JavaScript error in the onload event.\n" +
            "      This is often a problem to using normal Javascript injection\n" +
            "      techniques.')]")
    public WebElement JavaScriptErrorPageText;

    public Boolean validatePageLanding(){
        JavaScriptErrorPageText.isDisplayed();
        return true;
    }

    public Boolean containsJavaScriptError(String error) {
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        Boolean errorMatched = false;
        for (LogEntry entry : entries) {
            System.out.println(entry.toString());
            if (entry.toString().contains(error)) {
                errorMatched = true;
                break;
            }
        }
        return errorMatched;
    }
}
