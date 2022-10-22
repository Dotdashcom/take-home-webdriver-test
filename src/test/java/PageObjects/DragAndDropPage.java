package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{
    @FindBy (xpath = "//*[@id='column-a']")
    public WebElement columnA;

    @FindBy (xpath = "//*[@id=\"column-a\"]/header")
    public WebElement columnAHeader;

    @FindBy (xpath = "//*[@id='column-b']")
    public WebElement columnB;

    @FindBy (xpath = "//*[@id=\"column-b\"]/header")
    public WebElement columnBHeader;
}
