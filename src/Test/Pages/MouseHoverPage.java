package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage {
    public MouseHoverPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> profiles;

    public String HoverOverImages() {
        Actions actions = new Actions(Driver.GetDriver());
        String text = null;
        for (int i = 0; i < 3; i++) {
            int child = 3 + i;
            actions.moveToElement(Driver.GetDriver().findElement(By.cssSelector("div.figure:nth-child(" + child + ") > img:nth-child(1)"))).perform();
            WebElement userName = Driver.GetDriver().findElement(By.cssSelector("div.figure:nth-child(" + child + ") > div:nth-child(2) > h5:nth-child(1)"));
            if (userName.getText().contains("user" + (i + 1))) {
                text += userName.getText()+ " ";

            }
        }
        return text;
    }
}
