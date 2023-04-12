package page_object_model.hover_page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.PreparedStatement;
import java.util.List;

public class HoverPage extends Base {
    public HoverPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/div")
    private List<WebElement> allProfiles;


    public HoverPage selectProfile(int index) {
        WebElement profile = driver.findElement(By.xpath("//div[@class='example']/div["+index+"]/img"));
        Actions actions = new Actions(driver);
        waitForVisibilityOfElement(profile);
        actions.moveToElement(profile).perform();
        return new HoverPage();
    }

    public String userName(int index) {
        if (index == 1) {
            String result = driver.findElement(By.xpath("//div[@class='example']/div//h5[text()='name: user1']")).getText();
            return result;
        } else if (index == 2) {
            String result = driver.findElement(By.xpath("//div[@class='example']/div//h5[text()='name: user2']")).getText();
            return result;
        } else if (index == 3) {
            String result=driver.findElement(By.xpath("//div[@class='example']/div//h5[text()='name: user3']")).getText();
            return result;
        }
        return null;
    }


}
