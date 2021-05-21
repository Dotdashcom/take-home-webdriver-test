package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DragDropPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "drag_and_drop";
    //Box A
    @FindBy(id="column-a")
    private WebElement boxA;
    //Box A header
    @FindBy(xpath="//div[@id='column-a']/header")
    private WebElement boxAHeader;
    //Box B
    @FindBy(id="column-b")
    private WebElement boxB;
    //Box B header
    @FindBy(xpath="//div[@id='column-b']/header")
    private WebElement boxBHeader;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public DragDropPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Drag and Drop");
    }

    //Validate default positions
    public void validateDefaultBoxes() {
        assertEquals(boxAHeader.getText(),"A");
        assertEquals(boxBHeader.getText(),"B");
    }

    //Drag the box in left arg onto right
    public void dragBoxes() {
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(boxA)
                .moveToElement(boxB)
                .release(boxB)
                .build();
        dragAndDrop.perform();
    }

    //Validate boxes swapped
    public void validateBoxPosition() {
        assertEquals(boxAHeader.getText(),"B");
        assertEquals(boxBHeader.getText(),"A");
    }
}
