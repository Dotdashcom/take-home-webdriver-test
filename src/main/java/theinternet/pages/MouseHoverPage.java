package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MouseHoverPage extends BasePage{
    public MouseHoverPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Hovers')]")
    public WebElement mouseHoverPageHeader;
    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> mouseHoverImages;

    @FindBy(xpath = "//h5[contains(.,'name: user1')]")
    public WebElement mouseHoverPageImageText1;
    @FindBy(xpath = "//a[@href='/users/1'][contains(.,'View profile')]")
    public WebElement mouseHoverPageImageLink1;
    @FindBy(xpath = "//h5[contains(.,'name: user2')]")
    public WebElement mouseHoverPageImageText2;
    @FindBy(xpath = "//a[@href='/users/2'][contains(.,'View profile')]")
    public WebElement mouseHoverPageImageLink2;
    @FindBy(xpath = "//h5[contains(.,'name: user3')]")
    public WebElement mouseHoverPageImageText3;
    @FindBy(xpath = "//a[@href='/users/3'][contains(.,'View profile')]")
    public WebElement mouseHoverPageImageLink3;

    public Boolean validatePageLanding(){
        mouseHoverPageHeader.isDisplayed();
        for ( WebElement image : mouseHoverImages) {
            image.isDisplayed();
        }
        return true;
    }

    public Boolean mouseHover(String option) throws InterruptedException {
        Actions action = new Actions(driver);
        switch(option){
            case "1":
                action.moveToElement(mouseHoverImages.get(0)).perform();
                Thread.sleep(2000);
                mouseHoverPageImageText1.isDisplayed();
                mouseHoverPageImageLink1.isDisplayed();
                return true;
            case "2":
                action.moveToElement(mouseHoverImages.get(1)).perform();
                Thread.sleep(2000);
                mouseHoverPageImageText2.isDisplayed();
                mouseHoverPageImageLink2.isDisplayed();
                return true;
            case "3":
                action.moveToElement(mouseHoverImages.get(2)).perform();
                Thread.sleep(2000);
                mouseHoverPageImageText3.isDisplayed();
                mouseHoverPageImageLink3.isDisplayed();
                return true;

        }
        return false;
    }
}
