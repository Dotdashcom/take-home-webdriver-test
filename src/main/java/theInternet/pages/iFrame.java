package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class iFrame {


    public iFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Frames")
    WebElement Frames;

    @FindBy(linkText = "iFrame")
    WebElement iframe;

    @FindBy(xpath = "//p")
    WebElement writeText;


    public void iFramePractice(WebDriver driver){
        Frames.click();
        iframe.click();
        driver.switchTo().frame("mce_0_ifr");
        writeText.clear();
        String text= "It's simple and plain!";
        writeText.sendKeys(text);

        Assert.assertTrue(writeText.getText().equals(text));


    }
}
