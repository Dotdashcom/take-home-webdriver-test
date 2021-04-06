package TakeHome.pages;

import TakeHome.utilities.BrowserUtils;
import TakeHome.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverPage extends BasePage {

    public void hoverOverUser(int userNum) {
        WebElement user = Driver.get().findElement(By.xpath("//*[@class='figure'][" + userNum + "]"));
        BrowserUtils.hover(user);
    }

    public boolean verifyUserInfoDisplayed (int userNum) {
        return Driver.get().findElement(By.xpath("//*[@href='/users/" + userNum +"']")).isDisplayed();
    }
}
