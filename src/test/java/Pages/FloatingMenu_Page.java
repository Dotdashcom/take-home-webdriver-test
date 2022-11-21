package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class FloatingMenu_Page extends setWrapper {

    By Paragraph_loc= By.xpath("//div/p[1]");
    public FloatingMenu_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void scrollingNdAssert () {
    scrollingThePage();
    assertisDisplayed("true",Paragraph_loc);
    }
}
