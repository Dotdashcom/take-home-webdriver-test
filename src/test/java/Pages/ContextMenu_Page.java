package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrapper.setWrapper;

public class ContextMenu_Page extends setWrapper {
    By rightClick_loc=By.id("hot-spot");
    public ContextMenu_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome (){
        chromeDriverSetUp();
    }
    public void setUrl(String RemainUrl) {
        goToURL(UrlPref+RemainUrl);
    }

    public void rightClickAndAssert() {
    rightClickContext(webelement_meth(rightClick_loc));

    }
    public void assertRightClick () {
        switchToalert();
        myassertValidation("You selected a context menu",printAlertText(),1);

    }


}
