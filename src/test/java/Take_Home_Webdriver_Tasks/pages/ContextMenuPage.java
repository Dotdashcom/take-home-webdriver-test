package Take_Home_Webdriver_Tasks.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    @FindBy(id="hot-spot")
    public WebElement contextMenuBox;
}
