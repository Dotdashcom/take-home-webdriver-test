package page_object_model.secure_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends Base {
    public SecurePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='flash success']")
    public static WebElement flashSuccessLoginText;
}
