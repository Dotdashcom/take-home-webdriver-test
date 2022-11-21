package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class DynamicContent_Page extends setWrapper {
    By dynamicContent_loc= By.xpath("//div[@class='large-10 columns large-centered']//child::div[@class='row'][1]");
    String DynamicContentBefore;
    String DynamicContentAfter;
    public DynamicContent_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void refreshThePageNdAssert (int timesToBeRefreshed) {
        waitFor(5,dynamicContent_loc);
        DynamicContentBefore= getTextFromLocator(dynamicContent_loc);
        int count=0;
        for (int i = 0; i < timesToBeRefreshed; i++) {
            waitFor(5,dynamicContent_loc);
            refreshPage();
            DynamicContentAfter= getTextFromLocator(dynamicContent_loc);
            myassertValidation(DynamicContentBefore,DynamicContentAfter,2);
            DynamicContentBefore = DynamicContentAfter;
        }
    }

}
