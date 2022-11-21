package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

import java.util.ArrayList;

public class NotificationMsgRendered_Page extends setWrapper {
    By notificationLink_Loc= By.xpath("//a[@href=\"/notification_message\"]");
    By MsgAler_Loc=By.id("flash");
    protected String successMsg="Action successful";
    protected String notSucessMsg="Action unsuccesful, please try again";

    public NotificationMsgRendered_Page(WebDriver driverDotDash) {
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void clicklinkToNotification (){
        clickonLinkNdAssert(notificationLink_Loc,MsgAler_Loc,successMsg,notSucessMsg);
        }
}
