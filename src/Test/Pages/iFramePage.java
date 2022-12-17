package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class iFramePage {
    public iFramePage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(xpath = "//p")
    private WebElement textBox;

    public void SwitchFrame(String text){
        Driver.GetDriver().switchTo().frame(iframe);
        textBox.clear();
        textBox.sendKeys(text);
        Driver.GetDriver().switchTo().defaultContent();
    }

}
