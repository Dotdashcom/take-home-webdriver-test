package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"mce_0_ifr\"]")
    WebElement iframe;

    WebElement body;

    @FindBy(xpath = "//button[@class=\"tox-notification__dismiss tox-button tox-button--naked tox-button--icon\"]")
    WebElement closeButton;

    public IframePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/iframe");
        PageFactory.initElements(this.driver, this);
    }

    public void switchIframe() {
        try {
            closeButton.click();
        } catch (Exception e) {
            //
        }
        this.driver.switchTo().frame(this.iframe);
        this.body = this.driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        this.body.click();
        this.body.sendKeys("Hello World!");
    }

    public void assertTextContent() {
        Assert.assertEquals("Your content goes here.Hello World!", this.body.getText());
    }
}
