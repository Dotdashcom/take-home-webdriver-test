package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class DynamicLoadingPage extends TestBase {

    @FindBy(css = "div#start > button")
    WebElement startBtn;
    @FindBy(css = "div#finish>h4")
    WebElement helloWorldText;

    public DynamicLoadingPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void clickOnStartBtn() {
        startBtn.click();
        utils.visibleElementWait(helloWorldText);
    }

    public String getFinishText() {
        return helloWorldText.getText();
    }

}
