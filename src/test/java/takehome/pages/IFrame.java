package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;

public class IFrame {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    @FindBy(linkText = "Frames")
    private WebElement framesLink;
    @FindBy(linkText = "iFrame")
    private WebElement iFrameLink;
    @FindBy(id = "mce_0_ifr")
    private WebElement iFrame;
    @FindBy(xpath = "//body[@id='tinymce']//p")
    private WebElement textArea;
public void writeIntoIFrame(){
    framesLink.click();
    iFrameLink.click();
    wait.until(ExpectedConditions.visibilityOf(iFrame));
    Driver.getDriver().switchTo().frame("mce_0_ifr");


}
public String getTextFromFrame(String text){
    textArea.clear();
    BrowserUtilities.wait(2);
    textArea.sendKeys(text);
    return textArea.getText();
}



























    public IFrame(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

}
