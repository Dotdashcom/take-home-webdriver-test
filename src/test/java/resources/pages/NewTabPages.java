package resources.pages;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class NewTabPages extends BaseClass {

    public NewTabPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.example>a")
    WebElement clickHereLink;

    @FindBy(css="div.example>h3")
    WebElement newTabText;

    public void clickLink() {
        clickHereLink.click();
    }

    public void switchNewTab() {
        Set<String>WinHAn= driver.getWindowHandles();
        ArrayList<String> handleArrList= new ArrayList(WinHAn);
        driver.switchTo().window(handleArrList.get(1));
    }
    public String assertText() {
        String tabText=newTabText.getText();
        return tabText;

    }
}
