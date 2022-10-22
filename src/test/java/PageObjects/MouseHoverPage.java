package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MouseHoverPage extends BasePage {
    @FindBy (xpath = "(//div[@class='figure'])[1]")
    public WebElement image1;

    @FindBy (xpath = "(//div[@class='figure'])[2]")
    public WebElement image2;

    @FindBy (xpath = "(//div[@class='figure'])[3]")
    public WebElement image3;

    @FindBy (xpath = "//h5[.='name: user1']")
    public WebElement image1Content;

    @FindBy (xpath = "//h5[.='name: user2']")
    public WebElement image2Content;

    @FindBy (xpath = "//h5[.='name: user3']")
    public WebElement image3Content;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div")
    public List<WebElement> allImages;

}
