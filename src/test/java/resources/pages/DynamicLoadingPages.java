package resources.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.utilities.BaseClass;
import org.testng.Assert;


public class DynamicLoadingPages extends BaseClass {

    public DynamicLoadingPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div#start>button")
    WebElement startButton;

    @FindBy(css="div#finish>h4")
    WebElement helloWorldTxt;

    public void userClickStart() {

        startButton.click();
    }

    public void userVerifyHelloWord() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(helloWorldTxt));

    }

    public void userVerifyHelloWordText() {
        String hello=helloWorldTxt.getText();
        System.out.println(helloWorldTxt.getText());
        Assert.assertEquals(hello, (prop.getProperty("helloworldText")).trim());
    }

}
