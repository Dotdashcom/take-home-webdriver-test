package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

import java.util.List;

public class MouseHoverPage extends TestBase {
    WebDriver driver = TestBase.getInstance().getDriver();
    @FindBy(css = ".example>.figure")
    List<WebElement> userImageList;
    @FindBy(css = ".figure>.figcaption")
    List<WebElement> figCaptionList;

    public MouseHoverPage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> imageHover() {
        return userImageList;
    }

    public List<WebElement> displayContent() {
        return figCaptionList;
    }
}
