package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FloatingMenuPage {
    private WebDriver driver;
    //JS Executor
    JavascriptExecutor js;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "floating_menu";

    //Floating menu
    @FindBy(id = "menu")
    private WebElement floatingMenu;

    //Constructor
    public FloatingMenuPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        js = (JavascriptExecutor) driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Verify floating menu
    public void verifyFloat() {
        assertTrue(floatingMenu.isDisplayed());
        //Scroll to the end of page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //assert the floating menu
        assertTrue(floatingMenu.isDisplayed());
        //Scroll to middle of page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
        //assert the floating menu
        assertTrue(floatingMenu.isDisplayed());
    }
}
