package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

    private WebDriver driver;

    public IFramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "iFrame")
    private WebElement iFrameLink;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    private WebElement frameField;

    @FindBy(xpath = "//*[@id='tinymce']/p")
    private WebElement textBoxField;

    public void enterTextInBox(String text) {
        iFrameLink.click();
        driver.switchTo().frame(frameField);
        textBoxField.clear();
        textBoxField.sendKeys(text);
    }

    public String verifyTextInBox() {
        return textBoxField.getText();
    }




}
