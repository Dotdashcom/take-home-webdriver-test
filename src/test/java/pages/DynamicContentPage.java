package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DynamicContentPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "dynamic_content";
    //Content text
    @FindBy(xpath="//div[@class='large-10 columns']")
    private List<WebElement> contentText;
    //Page Heading
    @FindBy(tagName = "h3")
    private WebElement headerText;

    //Constructor
    public DynamicContentPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Validate page title
    public void validatePageTitle() {
        assertEquals(headerText.getText(),"Dynamic Content");
    }

    //Read the Content text
    public String[] readContentTexts() {
        String[] contentRowTexts = new String[contentText.size()];
        for(int i = 0; i < contentText.size(); i++) {
            contentRowTexts[i] = contentText.get(i).getText();
        }
        return contentRowTexts;
    }

    //Validate the content is different upon refresh
    public void validateContentChange(String[] orgContentArr) {
        for(int i = 0; i < contentText.size(); i++) {
            String currentText = contentText.get(i).getText();
            assertNotEquals(currentText, orgContentArr[i]);
        }
    }
}
