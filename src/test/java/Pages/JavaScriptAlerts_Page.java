package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class JavaScriptAlerts_Page extends setWrapper {
    By JsAlet_loc= By.xpath("//ul/li[1]/button");
    By JsConfirm_loc= By.xpath("//ul/li[2]/button");
    By JsPrompt_loc= By.xpath("//ul/li[3]/button");
    By messageTypedResult=By.xpath("//p[@id=\"result\"]");
    protected String AlertMessage="I am a JS Alert";
    protected String ConfirmMessage="I am a JS Confirm";
    protected String MessageTyped="Typing Message";
    public JavaScriptAlerts_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void  setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void jsAlertNdAssert () {
        //Handle Alert JS
        waitFor(8, JsAlet_loc);
        clickonButton(JsAlet_loc);
        switchToalert();
        myassertValidation(AlertMessage, printAlertText(), 1);
        dissmissOrAcceptAlert(true);
    }
    public void jsConfirmNdAssert () {
        //Handle JS Confirm
        waitFor(8, JsConfirm_loc);
        clickonButton(JsConfirm_loc);
        switchToalert();
        myassertValidation(ConfirmMessage, printAlertText(), 1);
        dissmissOrAcceptAlert(true);
    }
    public void jsPromptNdAssert () {
        //Handle JS Confirm
        waitFor(8,JsPrompt_loc);
        clickonButton(JsPrompt_loc);
        switchToalert();
        sendKeysToAlert(MessageTyped);
        dissmissOrAcceptAlert(true);
        myassertValidation("You entered: "
                +MessageTyped,getTextFromLocator(messageTypedResult),1);

    }
}
