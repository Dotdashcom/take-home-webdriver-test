package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {

    @FindBy (id = "tinymce")
    public WebElement commentBody;
}
