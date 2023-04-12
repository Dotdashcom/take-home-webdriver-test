package page_object_model.new_tab_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPage extends Base {
    public WindowPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Click Here']")
    private WebElement clickHereLink;


    public NewTabPage setClickHereLink() {
        clickOnElement(clickHereLink);
        return new NewTabPage();
    }
}
