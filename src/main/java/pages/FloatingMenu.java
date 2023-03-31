package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Utils.BrowserUtils;

public class FloatingMenu {
    public FloatingMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    //    @FindBy(tagName = "//li")
//    List<WebElement> menu;
    @FindBy(xpath = "//li[.='News']")
    WebElement newsLink;
    @FindBy(xpath = "//div[@style='text-align: center;']")
    WebElement scrollInto;

    public void scroll(WebDriver driver) {
        BrowserUtils.scrollIntiView(driver, scrollInto);
    }

    public boolean isMenuDisplayed() {

        return newsLink.isDisplayed();
    }
}
