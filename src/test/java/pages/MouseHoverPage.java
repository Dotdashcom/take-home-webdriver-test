package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MouseHoverPage {

    public MouseHoverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "//h3")
    public WebElement header;

    @FindBy(xpath = "//img[@src='/img/avatar-blank.jpg']")
    public List<WebElement> allimages;

    @FindBy(xpath = "//h5")
    public List<WebElement> usersText;

}
