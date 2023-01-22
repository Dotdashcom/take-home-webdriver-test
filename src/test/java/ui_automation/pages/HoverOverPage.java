package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class HoverOverPage extends BasePage{

    public HoverOverPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='example']/div/div/h5")
    public List<WebElement> users;


    @FindBy(xpath = "//div[@class='example']/div/div/h5[1]")
    public WebElement user1;

    @FindBy(xpath = "//div[@class='figure']/img[1]")
    public WebElement img1;



    @FindBy(xpath = "//div[@class='figure']/img")
    public List<WebElement> imgs;



}
