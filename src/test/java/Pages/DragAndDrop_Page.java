package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.setWrapper;

public class DragAndDrop_Page extends setWrapper {

    By BoxA = By.id("column-a");
    By BoxAXpath_Loc=By.xpath("//*[@id=\"column-a\"]");
    By BoxBXpath_Loc=By.xpath("//*[@id=\"column-b\"]");
    protected String ValueA="A";
    protected String ValueB="B";

    public DragAndDrop_Page (WebDriver driverDotDash){
        super(driverDotDash);
    }
    public void setChrome(){
        chromeDriverSetUp();
    }
    public void setUrl(String url) {
        goToURL(UrlPref+url);
    }
    public void goTodragndDropNdAssert() {

        dragDropJs(webelement_meth(BoxAXpath_Loc),webelement_meth(BoxBXpath_Loc),ValueA,ValueB);
    }
}
