package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class iFramePage {
    public iFramePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='iFrame']")
    public WebElement iframeBtn;

    @FindBy(id = "tinymce")
    public WebElement contentBody;
}
