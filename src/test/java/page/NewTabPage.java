package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Set;

public class NewTabPage extends PageObject {
    public NewTabPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Click Here")
    private WebElement clickHere;

    public void clickLinkToLaunchNewTab() {
        clickHere.click();
    }

    public String getTabText() {
        Set<String> windowHandles = driver.getWindowHandles();
        String nextWindowHandle = (String) windowHandles.toArray()[1];
        driver.switchTo().window(nextWindowHandle);
        return driver.findElement(By.tagName("h3")).getText();
    }
}
