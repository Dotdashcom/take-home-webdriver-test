package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WindowsPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "windows";
    //Link that opens in new tab
    @FindBy(linkText="Click Here")
    private WebElement newTabLink;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public WindowsPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Opening a new window");
    }

    //Verify new tab
    public void verifyNewTab() {
        newTabLink.click();
        //Get the list of window handles and then switch to the latter one
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs.get(1)));
        assertEquals(headerText.getText(),"New Window");
    }
}
