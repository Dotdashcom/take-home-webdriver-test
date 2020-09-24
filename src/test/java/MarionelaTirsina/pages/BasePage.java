package MarionelaTirsina.pages;

import org.jsoup.Connection;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
