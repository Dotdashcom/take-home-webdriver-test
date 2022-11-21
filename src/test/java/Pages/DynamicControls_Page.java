package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class DynamicControls_Page extends setWrapper {
    By removeAddBtn_loc = By.xpath("//form[@id='checkbox-example']/button");
    By checkBox_loc= By.xpath("//form[@id='checkbox-example']/div/input");
    By itsGoneItsAble_loc = By.xpath("//form/p[@id='message']");
    By enableDisableBtn_loc=By.xpath("//form[@id='input-example']/button");
    By itsEnable_Loc=By.xpath("//form[@id='input-example']/p");
    By textBox_loc=By.xpath("//form[@id='input-example']/input");
    protected String itsGoneText= "It's gone!";
    protected String itsEnabledText = "It's enabled!";
    protected String itsDesabledText = "It's disabled!";

    public DynamicControls_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url){
        goToURL(UrlPref+url);
    }

    public void removeAddBtn () {
        clickonButton(removeAddBtn_loc);
        waitFor(5,itsGoneItsAble_loc);
        isPresentonScreen(checkBox_loc);
        myassertValidation("It's gone!",
                getTextFromLocator(itsGoneItsAble_loc),1);
    }
    public void enableDisableBtn (){

        clickonButton(enableDisableBtn_loc);
        waitFor(5,itsEnable_Loc);
        myassertValidation("It's enabled!",itsEnabledText,1);
        myassertValidation("true",
                String.valueOf(webelement_meth(textBox_loc).isEnabled()),
                1);
        clickonButton(enableDisableBtn_loc);
        waitFor(5,itsEnable_Loc);
        myassertValidation("It's disabled!",itsDesabledText,1);
        myassertValidation("false",
                String.valueOf(webelement_meth(textBox_loc).isEnabled()),
                1);

    }
}
