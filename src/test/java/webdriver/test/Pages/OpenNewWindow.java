package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

import java.util.Set;


public class OpenNewWindow {

    //local webdriver variable
    private WebDriver driver;

    @FindBy(xpath = "//a[@target='_blank']")
    public WebElement openNewWindowLink;

    @FindBy(xpath = "//h3")
    public WebElement newWindowText;

    //Page Class Constructor
    public OpenNewWindow(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void ClickNewWindowLink() {

        openNewWindowLink.click();

    }

    public String getNewWindowText() {

        Set<String> handles = driver.getWindowHandles();

        String nextHandle = (String)handles.toArray()[1];

        driver.switchTo().window(nextHandle);

        return newWindowText.getText();
    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/windows");
    }
}
