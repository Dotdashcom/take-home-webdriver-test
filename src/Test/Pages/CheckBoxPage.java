package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBoxPage {
    public CheckBoxPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(css = "input:nth-child(1)")
    private WebElement checkBox1;

    @FindBy(css = "input:nth-child(3)")
    private WebElement checkBox2;

    public void ClickCheckBox1() {
        HelpfulMethods.clickWithWait(checkBox1);
        Assert.assertTrue(checkBox1.isSelected());
    }
    public void ClickCheckBox2() {
        HelpfulMethods.clickWithWait(checkBox2);
           Assert.assertFalse(checkBox2.isSelected());
    }
}
