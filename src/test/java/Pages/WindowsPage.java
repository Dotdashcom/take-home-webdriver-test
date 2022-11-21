package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class WindowsPage extends setWrapper {
    By ClickHereLink_Loc= By.linkText("Click Here");
    By NewWindow_Loc=By.xpath("//div/h3[text()=\"New Window\"]");
    public WindowsPage(WebDriver driverDotDash) {
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void clickOnNewWindowLink(){
        waitFor(3,ClickHereLink_Loc);
        clickonButton(ClickHereLink_Loc);
        handleNewWindow();
       myassertValidation("New Window",getTextFromLocator(NewWindow_Loc),1);

    }
    public void closepreviousWind (){
        closeAllWindows();
        returnToPreviousWindow();
        closeAllWindows();
    }
}
