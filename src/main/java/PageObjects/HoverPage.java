package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoverPage {
    public WebDriver driver;

    public HoverPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='figure']")
    private List <WebElement> users;

    @FindBy(xpath = "//div[@class='figcaption']")
    private List<WebElement> captions;




    public boolean validateInfoDiplayEachUserHover() throws InterruptedException {
        for (int i =0;i< users.size();i++){
            Helpers.MoveMouseOverElement(users.get(i));
            if (Helpers.ElementIsPresent(captions.get(i))){
                continue;
            }
            else return false;
        }

      return true;
    }

}
