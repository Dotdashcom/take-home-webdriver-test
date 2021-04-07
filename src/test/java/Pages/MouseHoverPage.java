package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MouseHoverPage {
    public MouseHoverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='figure']")
    public WebElement image;

    @FindBy(xpath = "//div[@class='example']/div/div")
    public WebElement profile;
}
