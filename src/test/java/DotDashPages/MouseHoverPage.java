package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage {

    public WebDriver ldriver;

    public MouseHoverPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //Capture the images
    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div/img")
    public List<WebElement> imgs;

    //Capture image1
    @FindBy(xpath="//body/div[2]/div[1]/div[1]/div[1]/img[1]")
    public WebElement img1;

    //Capture image2
    @FindBy(xpath="//body/div[2]/div[1]/div[1]/div[2]/img[1]")
    public WebElement img2;

    //Capture image2
    @FindBy(xpath="//body/div[2]/div[1]/div[1]/div[3]/img[1]")
    public WebElement img3;

    //Capture caption1
    @FindBy(xpath="//h5[contains(text(),'name: user1')]")
    public WebElement caption1;

    //Capture caption1
    @FindBy(xpath="//h5[contains(text(),'name: user2')]")
    public WebElement caption2;

    //Capture caption1
    @FindBy(xpath="//h5[contains(text(),'name: user3')]")
    public WebElement caption3;

    //Capture the additional information
    @FindBy(xpath = "//div[@class='figcaption']/h5")
    public WebElement captions;

    //Get the information when performed mousehover action
    /*public boolean mousehoverimg()
    {
        Actions act = new Actions(ldriver);
        boolean temp = false;
        for (WebElement e : imgs)
        {
            act.moveToElement(e).build().perform();

            if(additionalinfo.isDisplayed())
            {
                temp = true;
            }
            else
            {
                temp =false;
            }
        }
        if(temp == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }*/




}
