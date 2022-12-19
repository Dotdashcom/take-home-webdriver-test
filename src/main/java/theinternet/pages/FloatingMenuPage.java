package theinternet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FloatingMenuPage extends BasePage{
    public FloatingMenuPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Floating Menu')]")
    public WebElement FloatingMenuPageHeader;
    @FindBy(xpath = "//a[contains(.,'Home')]")
    public WebElement FloatingMenuPageHome;
    @FindBy(xpath = "//a[contains(.,'News')]")
    public WebElement FloatingMenuPageNews;
    @FindBy(xpath = "//a[contains(.,'Contact')]")
    public WebElement FloatingMenuPageContact;
    @FindBy(xpath = "//a[contains(.,'About')]")
    public WebElement FloatingMenuPageAbout;

    public Boolean validatePageLanding(){
        FloatingMenuPageHeader.isDisplayed();
        FloatingMenuPageHome.isDisplayed();
        FloatingMenuPageNews.isDisplayed();
        FloatingMenuPageContact.isDisplayed();
        FloatingMenuPageAbout.isDisplayed();
        return true;
    }

    public void scrollPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    public Boolean isNavVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(FloatingMenuPageHome));
        wait.until(ExpectedConditions.visibilityOf(FloatingMenuPageNews));
        wait.until(ExpectedConditions.visibilityOf(FloatingMenuPageContact));
        wait.until(ExpectedConditions.visibilityOf(FloatingMenuPageAbout));
        return true;
    }
}
