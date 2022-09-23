package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {

    @FindBy(xpath = "/html/body/p")
    protected WebElement iFrameText;
    @FindBy(css = "div[class=tox-icon]>svg>path")
    protected WebElement alertCloseButton;

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void typeInsideIFrame(){
        waitForElementToBeClickable("div[class=tox-icon]>svg>path");
        Actions actions = new Actions(driver);
        actions.click(alertCloseButton).build().perform();

        driver.switchTo().frame(0);
        pauseInSeconds(1);
        ((JavascriptExecutor)driver).executeScript("document.querySelectorAll('body[class=\"mce-content-body \"]>p')[0].innerHTML=\"Iam inside the iFrame\"");
    }
    public String  getIframeText(){
        return iFrameText.getText();
    }
}
