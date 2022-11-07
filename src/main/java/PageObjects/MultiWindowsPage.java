package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MultiWindowsPage {

    public WebDriver driver;

    public MultiWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Click Here']")
    private WebElement clickHere;

    public boolean validateTextPage(int index,String text) throws InterruptedException {
        Helpers.SwitchTab(index);
        return Helpers.SearchTextPageSource(text);
    }


    public void clickNewWindow() {
        Helpers.ClickElement(clickHere);
    }
}
