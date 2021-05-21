package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.util.List;

import static org.junit.Assert.*;

public class ContextMenuPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "context_menu";
    //Internet box
    @FindBy(id="hot-spot")
    private WebElement internetBox;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public ContextMenuPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Context Menu");
    }

    //Right click the box
    public void rightClickElement() {
        Actions actions = new Actions(driver);
        actions.contextClick(internetBox).perform();

    }

    //Validate alert
    public void validateAlertPresent() {
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait until alert pops up
        assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
    }

    //Accept alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
