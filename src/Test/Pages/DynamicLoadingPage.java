package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/dynamic_loading/1']")
    private WebElement element1;

    @FindBy(xpath = "//a[@href='/dynamic_loading/2']")
    private WebElement element2;

    @FindBy(css = "button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement successMessage;

    public void DynamicElementClickingElement1(){
        element1.click();
        HelpfulMethods.staticWait(5);
        HelpfulMethods.clickWithWait(startButton);
    }
    public void DynamicElementClickingElement2(){
        element2.click();
        HelpfulMethods.clickWithWait(startButton);
    }
    public String SuccessMessage(){
         return successMessage.getText();
    }
}
