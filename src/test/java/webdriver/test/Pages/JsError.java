package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;


public class JsError {

    //local webdriver variable
    private WebDriver driver;


    //Page Class Constructor
    public JsError(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public LogEntries checkJsError() {
        return driver.manage().logs().get(LogType.BROWSER);

    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/javascript_error");
    }
}
