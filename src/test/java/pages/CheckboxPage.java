package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckboxPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "checkboxes";
    //Checkboxes
    @FindBy(xpath="//input[@type='checkbox']")
    private List<WebElement> checkbox;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public CheckboxPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Method to check checkboxes
    public void check(int checkBoxIndex) {
        checkbox.get(checkBoxIndex).click();
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Checkboxes");
    }

    //Validate checkbox is checked
    public void validateCheckBoxChecked(int checkBoxIndex) {
        assertNotEquals(checkbox.get(checkBoxIndex).getAttribute("checked"), null);
    }

    //Validate checkbox is unchecked
    public void validateCheckBoxUnchecked(int checkBoxIndex) {
        assertEquals(checkbox.get(checkBoxIndex).getAttribute("checked"), null);
    }
}
