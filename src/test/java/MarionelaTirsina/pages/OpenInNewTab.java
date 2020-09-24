package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenInNewTab extends BasePage {
    @FindBy(css = "a[href='/windows/new']")
    public WebElement openNeWindowLink;
    ///
}
