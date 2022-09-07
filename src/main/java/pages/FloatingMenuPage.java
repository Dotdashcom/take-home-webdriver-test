package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class FloatingMenuPage extends TestBase {
    @FindBy(id = "menu")
    WebElement floatingMenu;

    public FloatingMenuPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public WebElement floatingMenu() {
        return floatingMenu;
    }


}
