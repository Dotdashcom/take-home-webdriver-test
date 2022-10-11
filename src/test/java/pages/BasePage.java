package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Driver;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver , this);
    }

    @FindBy(id = "page-footer")
    public WebElement pageFooter;

    @FindBy(xpath = "//h3")
    public WebElement pageHeader;
}
