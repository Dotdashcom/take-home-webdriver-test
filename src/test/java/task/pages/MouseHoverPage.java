package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MouseHoverPage extends BasePage {

    @FindBy (xpath = "(//img[@src=\"/img/avatar-blank.jpg\"])[1]")
    public WebElement image1;

    @FindBy (xpath = "(//img[@src=\"/img/avatar-blank.jpg\"])[2]")
    public WebElement image2;

    @FindBy (xpath = "(//img[@src=\"/img/avatar-blank.jpg\"])[3]")
    public WebElement image3;

    @FindBy (xpath = "//h5[text()='name: user1']")
    public WebElement textVerIMG1;

    @FindBy (xpath = "//h5[text()='name: user2']")
    public WebElement textVerIMG2;

    @FindBy (xpath = "//h5[text()='name: user3']")
    public WebElement textVerIMG3;
}
