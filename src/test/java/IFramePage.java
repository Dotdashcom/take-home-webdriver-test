import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IFramePage extends PageObject{

    @FindBy(id = "tinymce")
    public WebElement Frame_Text;
    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public void iframeactions()
    {
        driver.switchTo().frame("mce_0_ifr");
        Frame_Text.clear();
        String Enter_Text = "Testing is very Important!";
        Frame_Text.sendKeys(Enter_Text);

        Assert.assertEquals(Frame_Text.getText(),Enter_Text);

    }
}
