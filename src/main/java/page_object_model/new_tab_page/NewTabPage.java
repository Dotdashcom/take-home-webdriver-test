package page_object_model.new_tab_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage extends Base {
    public NewTabPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    public static WebElement newWindowMessage;
}
