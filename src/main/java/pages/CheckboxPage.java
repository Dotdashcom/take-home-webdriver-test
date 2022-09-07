package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class CheckboxPage extends TestBase {
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkBox1;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement checkBox2;

    public CheckboxPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public WebElement selectCheckbox() {

        checkBox1.click();
        return checkBox1;
    }

    public WebElement unselectCheckbox() {
        checkBox2.click();
        return checkBox2;
    }
}
