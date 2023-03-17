package resources.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class ContextMenuPages extends BaseClass {

    public ContextMenuPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div#hot-spot")
    WebElement contextBox;

    public void rightClickCxtBox() {
        Actions act= new Actions(driver);
        act.contextClick(contextBox).perform();
    }

    public String getTextOnAlert() {
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
        return alertText;
    }
}
