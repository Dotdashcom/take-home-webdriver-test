package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

import java.awt.*;

public class DynamicLoading_Page extends setWrapper {
    By StartButton_loc= By.xpath("//*[@id=\"start\"]/button");
    By HelloWorld_loc =By.xpath("//div[@id=\"finish\"]/h4");
    String HelloWorld_Text= "Hello World!";
    public DynamicLoading_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void startbtnNdAssert (){
        clickonButton(StartButton_loc);
        waitFor(10,HelloWorld_loc);
        myassertValidation("Hello World!",
              getTextFromLocator(HelloWorld_loc),1);
    }
}
