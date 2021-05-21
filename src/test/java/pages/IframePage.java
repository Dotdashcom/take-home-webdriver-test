package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IframePage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "iframe";
    private static final String IFRAME_TEXT = "Sample text to see if the switch to iframe was successful";

    //Warning close
    @FindBy(xpath = "//div[@aria-label='Close']")
    private WebElement warningClose;
    //Iframe
    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;
    //Iframe text area
    @FindBy(xpath = "//body[@id='tinymce']/p")
    private WebElement iframeTextArea;

    //Constructor
    public IframePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Verify typing text in iframe
    public void verifyIframe() {
        warningClose.click();
        driver.switchTo().frame(iframe);
        iframeTextArea.clear();
        iframeTextArea.sendKeys(IFRAME_TEXT);
        assertEquals(iframeTextArea.getText(), IFRAME_TEXT);
    }
}
