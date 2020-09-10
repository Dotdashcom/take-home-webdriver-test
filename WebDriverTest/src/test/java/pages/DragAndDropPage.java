package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends Functions {
    @FindBy(id = "column-a")
    public WebElement squareA;

    @FindBy(id = "column-b")
    public WebElement squareB;

    @FindBy(xpath = "//div[@id='column-a']/header")
    public WebElement headerA;

    @FindBy(xpath = "//div[@id='column-b']/header")
    public WebElement headerB;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public DragAndDropPage() {

        PageFactory.initElements(driver, this);

    }

}
