package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPageObject extends BasePageObject {
    @FindBy(css = "div[class='figure']")
    private List<WebElement> avatars;
    @FindBy(css = "div[class='figure'] h5")
    private List<WebElement> names;
    @FindBy(css = "div[class='figure'] a")
    private List<WebElement> profiles;


    public MouseHoverPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int noOfAvatars() {
        return avatars.size();
    }

    public MouseHoverPageObject mouseHover(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        return this;
    }
    public List<WebElement> getAvatars() {
        return avatars;
    }

    public List<WebElement> getNames() {
        return names;
    }

    public List<WebElement> getProfiles() {
        return profiles;
    }

}
