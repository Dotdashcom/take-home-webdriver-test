package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage {

    @FindBy(className = "tox-icon")
    public WebElement toxBtn;

    @FindBy(id = "tinymce")
    public WebElement contentBody;
}
