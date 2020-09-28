package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavascriptUtilities;
import utilities.WaitUtilities;

public class FloatingMenuPage extends BasePage {

    @FindBy(id = "menu")
    //@FindBy(xpath = "//div[@id='menu']")
    private WebElement floatingMenu;


    public FloatingMenuPage(WebDriver driver) {
        super(driver, EndPointPath.FLOATING_MENU);

    }

    public boolean verifyFLoatingMenuStillDisplayedWhenScroll() {
        JavascriptUtilities.scrollDownByPixels(driver, 300);
        if (!JavascriptUtilities.isVisibleInViewport(driver, floatingMenu)) {
            return false;
        }
        JavascriptUtilities.scrollDownToBottomPage(driver);
        return JavascriptUtilities.isVisibleInViewport(driver, floatingMenu);
    }






}
