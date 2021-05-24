package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicLoadPage {
    private WebDriver driver;
    //explicit wait
    WebDriverWait wait;

    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "dynamic_loading/2";

    //Start button
    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;
    //Message
    @FindBy(id = "finish")
    private WebElement successText;

    //Constructor
    public DynamicLoadPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Dynamically Loaded Page Elements");
    }

    //Verify Clicking Start button
    public void verifyHelloWorld() {
        startButton.click();
        wait.until(ExpectedConditions.visibilityOf(successText));
        assertTrue(successText.getText().contains("Hello World"));
    }
}
