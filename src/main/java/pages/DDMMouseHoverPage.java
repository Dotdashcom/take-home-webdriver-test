package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DDMMouseHoverPage extends DDMBasePage  {

    @FindBy(css = "div.example > div > img")
    protected List<WebElement> listOfImages;

    @FindBy(css = "div.figcaption > h5")
    protected List<WebElement> userName;

    @FindBy(css = "div.figcaption > a")
    protected List<WebElement> viewProfileLink;

    public DDMMouseHoverPage(WebDriver driver)  {
        super(driver);
    }

    public void mouseHoverProfile(int index)  {
        Actions actions = new Actions(driver);
        actions.moveToElement(listOfImages.get(index)).build().perform();
    }

    public boolean isProfileDisplayed(int index)  {
        return (userName.get(index).isDisplayed() && viewProfileLink.get(index).isDisplayed());
    }
}