package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;



public class Iframe {

    //local webdriver variable
    private WebDriver driver;



    @FindBy(css = "div[aria-label='Close']")
    private WebElement closeIcon;

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrameEditorSection;

    @FindBy(id = "tinymce")
    public WebElement iFrameBodyEditor;

    //Page Class Constructor
    public Iframe(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void closeIcon() {
        closeIcon.click();
    }


    public void editTextInIframe(String keys) {

        driver.switchTo().frame(iFrameEditorSection);

        iFrameBodyEditor.clear();

        iFrameBodyEditor.click();

        iFrameBodyEditor.sendKeys(keys);

        driver.switchTo().defaultContent();

    }


    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/iframe");
    }
}
