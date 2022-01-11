package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.logging.*;

import java.util.List;

public class JavaScriptErrorPage {
    WebDriver driver;
    String javaScriptErrorUrl = "http://localhost:7080/javascript_error";

    public JavaScriptErrorPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.driver.get(javaScriptErrorUrl);
        PageFactory.initElements(webDriver, this);
    }

    public LogEntries getLogentries(){
        return driver.manage().logs().get(LogType.BROWSER);
    }

    public boolean containsError(List<String> logs, String errorMessage) {
        for(String log:logs){
            if(log.contains(errorMessage)) return true;
        }
        return false;
    }
}
