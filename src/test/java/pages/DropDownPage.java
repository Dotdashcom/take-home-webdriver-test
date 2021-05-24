package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CommonUtils;

import static org.junit.Assert.assertEquals;

public class DropDownPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "dropdown";
    //Dropdown
    @FindBy(id="dropdown")
    private WebElement dropDown;
    //Dropdown selected value
    @FindBy(xpath = "//option[@selected='selected']")
    private WebElement selectedValue;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public DropDownPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Dropdown List");
    }

    //Select the given option from the dropdown
    public void verifySelectOption(String optionValue) {
        assertEquals(selectedValue.getText(),"Please select an option");
        Select dropDownSelect = new Select(dropDown);
        dropDownSelect.selectByValue(optionValue);
        if(optionValue.equals("1")) {
            assertEquals(selectedValue.getText(),"Option 1");
        } else {
            assertEquals(selectedValue.getText(),"Option 2");
        }
    }
}
