package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class DragAndDropPage extends BaseClass {

    public DragAndDropPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Drag and Drop']")
    public WebElement dragAndDropPageHeader;

    @FindBy(id = "column-a")
    public WebElement aBox;

    @FindBy(id = "column-b")
    public WebElement bBox;

    @FindBy(xpath = "//*[@id='column-a']/header")
    public WebElement aBoxHeader;

    @FindBy(xpath = "//*[@id='column-b']/header")
    public WebElement bBoxHeader;
}
