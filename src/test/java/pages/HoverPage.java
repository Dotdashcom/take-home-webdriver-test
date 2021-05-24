package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HoverPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "hovers";
    //Images to hover on
    @FindBy(xpath="//div[@class='figure']")
    private List<WebElement> hoverImages;
    //Text under the images
    @FindBy(tagName="h5")
    private List<WebElement> userText;
    //Profile links under the images
    @FindBy(linkText="View profile")
    private WebElement profileLink;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public HoverPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Hovers");
    }

    //Verify hover over images
    public void hoverOverImages() {
        Actions actions = new Actions(driver);
        for(int i = 0; i < hoverImages.size(); i++) {
            actions.moveToElement(hoverImages.get(i)).perform();
            assertTrue(userText.get(i).isDisplayed());
            assertEquals(userText.get(i).getText(), "name: user" + Integer.valueOf(i+1));
            assertTrue(profileLink.isDisplayed());
        }
    }
}
