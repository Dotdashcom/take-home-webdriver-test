package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DynamicLoadingPage  extends BasePage{
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#start > button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement helloText;

    public void clickStartButtonAndWaitUntilLoadFinish(){
        clickButtonAndWaitUntilFinish(startButton);
    }

    public String getLoadedText(){
        return helloText.getText();
    }
}
