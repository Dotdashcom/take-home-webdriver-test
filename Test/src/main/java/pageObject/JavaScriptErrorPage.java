package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class JavaScriptErrorPage {

    String JavaScriptErrorPageUrl = "http://localhost:7080/javascript_error";
    WebDriver webDriver;

    public JavaScriptErrorPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(JavaScriptErrorPageUrl);
    }

    public LogEntries getErrors(){
        return webDriver.manage().logs().get(LogType.BROWSER);
    }
}
