package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FloatingMenuPage extends BasePage {

    @FindBy(xpath = "//div[@id=\"menu\"]/ul/li")
    public List<WebElement> floatingMenu;

    @FindBy (xpath = "//*[@id=\"page-footer\"]/div/div/a")
    public WebElement endPage;

}
