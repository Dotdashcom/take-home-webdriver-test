package src.main.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends BasePage {
    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content > div > div")
    private List<WebElement> list;


    public String getUserName(int index) {
        WebElement profileName = list.get(index).findElement(By.cssSelector("div.figcaption > h5"));

        return profileName.getText();
    }

    public String getProfileLink(int index) {
        WebElement profileLink = list.get(index).findElement(By.cssSelector("div.figcaption > a"));

        return profileLink.getAttribute("href");
    }



    public void hoverOnUser(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(list.get(index)).build().perform();
    }
}
