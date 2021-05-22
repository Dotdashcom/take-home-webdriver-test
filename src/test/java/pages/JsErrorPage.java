package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import static org.junit.Assert.*;

public class JsErrorPage {
    private WebDriver driver;
    //explicit wait
    WebDriverWait wait;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "javascript_error";
    //Error message text
    private static String typeErrorText = "Cannot read property 'xyz' of undefined";

    //Body text
    @FindBy(xpath="//body/p")
    private WebElement jsErrorText;

    //Constructor
    public JsErrorPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        wait = new WebDriverWait(driver,30);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Verify the JS error
    public void validateJsError() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry log: logs) {
            if(log.getMessage().contains("TypeError"))
                assertTrue(log.getMessage().contains(typeErrorText));
        }
    }
}
