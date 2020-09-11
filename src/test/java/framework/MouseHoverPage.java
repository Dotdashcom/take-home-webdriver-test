package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage extends BasePage{

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    WebElement avatarImg;

    @FindBy(xpath = "//*[contains(text(), 'user1')]//following-sibling::*[contains(text(), 'View profile')]")
    WebElement viewProfileLink;

    @FindBy(xpath = "//h2[contains(text(), 'Sinatra')]")
    WebElement successText;

    public MouseHoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void testMouseHover(WebDriver driver) {
        mouseHover(driver, avatarImg);
        if (isElementPresent(driver, viewProfileLink)) {
            clickOnElement(driver, viewProfileLink, "Success: Clicked on View Profile",
                    "Failed: Unable to click on View Profile");
        }
    }

    public boolean isSuccess (WebDriver driver) {
        boolean isPresent = false;
        if (isElementPresent(driver, successText)){
            isPresent = true;
        }
        return isPresent;
    }
}
