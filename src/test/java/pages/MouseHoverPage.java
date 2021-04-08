package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class MouseHoverPage {
    public MouseHoverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']//div[@class='figure']")
    public List <WebElement> figures;

    @FindBy(xpath = "//*[text()='name: user1']")
    public WebElement user1;

    @FindBy(xpath = "//*[text()='name: user2']")
    public WebElement user2;

    @FindBy(xpath = "//*[text()='name: user3']")
    public WebElement user3;
}
