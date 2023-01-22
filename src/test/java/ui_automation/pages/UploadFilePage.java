package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class UploadFilePage extends BasePage{

    public UploadFilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement uploadBtn;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    public WebElement veriffyUploadedFile;


}
