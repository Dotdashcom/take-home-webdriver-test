package page_object_model.floating_menu_page;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends Base {

    public FloatingMenuPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "menu")
    public static WebElement menu ;

    public void scrollDown(){
        // Scroll down the web page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

}
