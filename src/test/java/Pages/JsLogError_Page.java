package Pages;

import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class JsLogError_Page extends setWrapper {

    public JsLogError_Page(WebDriver driverDotDash) {
        super(driverDotDash);
    }

    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void handleJsErrorLogs(){
        getAvailableLogType();
        findJsErrorLogEntry();
    }
}
