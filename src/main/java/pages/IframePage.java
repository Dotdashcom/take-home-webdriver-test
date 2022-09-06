package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class IframePage extends TestBase {
    @FindBy(id = "mce_0_ifr")
    WebElement iFrame;
    @FindBy(css = "#tinymce>p")
    WebElement textBox;
    public IframePage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public WebElement getiFrame() {
        return iFrame;
    }

    public WebElement getTextBox() {
        return textBox;
    }

}
