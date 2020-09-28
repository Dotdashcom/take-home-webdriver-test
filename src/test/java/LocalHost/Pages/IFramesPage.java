package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IFramesPage {
    public IFramesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;



    public void switchingFrames(){
        Driver.getDriver().switchTo().frame(iframe);
        WebElement textbox = Driver.getDriver().findElement(By.id("tinymce"));
        String str="Hello There!!!";
        textbox.clear();
        textbox.sendKeys(str);
        Assert.assertEquals(textbox.getText(),str);

    }
}
