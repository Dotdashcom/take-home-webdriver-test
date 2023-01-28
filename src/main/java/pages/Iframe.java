package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Iframe {
    private WebDriver driver;
    private SoftAssert softAssert;

    public Iframe(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//body[@id='tinymce']/p")
    private WebElement iFrameTexBox;

    @FindBy(xpath = "//body[@id='tinymce']/p[1]")
    private WebElement actualText;
    public void testIframe() {
        navigateToIframePage();
        WebDriver myFrameDriver = driver.switchTo().frame("mce_0_ifr");
        WebElement myFrameElement = myFrameDriver.findElement(By.xpath("//body[@id='tinymce']/p"));
        myFrameElement.clear();
        myFrameElement.sendKeys(ConfigReader.getProperty("inputText"));
        softAssert.assertEquals(actualText.getText().trim(),ConfigReader.getProperty("inputText"),"Text did not change");
        myFrameDriver.switchTo().defaultContent();

    }

    private void navigateToIframePage(){
        driver.get(ConfigReader.getProperty("url")+"/iframe ");
    }
}
