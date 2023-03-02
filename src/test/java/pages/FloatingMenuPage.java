package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FloatingMenuPage {

    public FloatingMenuPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(xpath = "//div[@class='large-4 large-centered columns']")
    public WebElement lastElementOnPage;

    @FindBy(id="menu")
    public WebElement menuBtn;

    @FindBy(xpath = "//a[@href='#home']")
    public WebElement homeBtn;

    @FindBy(xpath = "//a[@href='#news']")
    public WebElement newsBtn;

    @FindBy(xpath = "//a[@href='#contact']")
    public WebElement contactBtn;

    @FindBy(xpath = "//a[@href='#about']")
    public WebElement aboutBtn;


}

