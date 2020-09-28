package takehome.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class HoverPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Actions actions = new Actions(Driver.getDriver());
    @FindBy(linkText = "Hovers")
    private WebElement hoverLink;
    @FindBy(css = "div:nth-of-type(1) > img[alt='User Avatar']")
     public WebElement firstImage;
    @FindBy(xpath = "//h5[text()='name: user1']")
    public WebElement firstImgTxt;
    @FindBy(css = "div:nth-of-type(2) > img[alt='User Avatar']")
   public WebElement secondImg;
    @FindBy(css = "div:nth-of-type(2) > .figcaption > h5")
  public WebElement secondImgText;
    public void clickOnHoverLink(){
        hoverLink.click();
    }
    public void hoverOverImages(WebElement element){
        actions.moveToElement(element).build().perform();
    }

    public String getImageText(WebElement imageText){

    return imageText.getText();
    }





    public HoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
