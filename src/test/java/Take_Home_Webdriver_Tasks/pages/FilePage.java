package Take_Home_Webdriver_Tasks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilePage extends BasePage{

    @FindBy (xpath = "//*[@id=\"content\"]/div/a")
    public List<WebElement> files;

    @FindBy (id = "file-upload")
    public WebElement chooseFile;

    @FindBy (id = "file-submit")
    public WebElement uploadBtn;

    @FindBy (xpath = "//div[@id=\"content\"]/div/h3")
    public WebElement uploadMsg;
}
