package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;

public class DynamicLoadingPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);


    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Dynamic Loading")
    private WebElement dLLink;
    @FindBy(css = "div > a:nth-of-type(2)")
    private WebElement example1Link;
    @FindBy(css = "div#start > button")
    private WebElement startButton;
    @FindBy(xpath = "//h4[text()='Hello World!']")
    private WebElement helloWorldText;


    public void clickOnStartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(dLLink));
        dLLink.click();
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.elementToBeClickable(example1Link));
        example1Link.click();
        BrowserUtilities.wait(2);
        startButton.click();
    }

    public String getText(){

        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        return helloWorldText.getText();
    }


}
