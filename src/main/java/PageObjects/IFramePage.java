package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {
    public IFramePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.TAG_NAME , using = "p")
    WebElement textArea;

    @FindBy( how = How.CSS , using = "a[href='/iframe']")
    WebElement iframeLink;

    public void enterTextInTextArea(WebDriver driver, String text){
        driver.switchTo().frame("mce_0_ifr");
        textArea.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public String getTextfromTextarea(WebDriver driver){
        driver.switchTo().frame("mce_0_ifr");
        return textArea.getText();
    }


    public void clickOniFrameLink() {
        iframeLink.click();
    }
}
