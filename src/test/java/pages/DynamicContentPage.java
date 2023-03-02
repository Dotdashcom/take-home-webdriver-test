package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DynamicContentPage {

    public DynamicContentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(xpath = "//div[@class='large-2 columns']/img")
    public List<WebElement> allimages;

    @FindBy(xpath = "//div[@class='large-10 columns']")
    public List<WebElement> allTextColumns;
}
