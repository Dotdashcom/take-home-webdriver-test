package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {

    @FindBy (xpath = "//div[@id=\"content\"]/div/div")
    public List<WebElement> allImages;


}
