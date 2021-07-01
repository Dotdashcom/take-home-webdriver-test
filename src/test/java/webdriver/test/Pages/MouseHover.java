package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

import java.util.List;



public class MouseHover {

    //local webdriver variable
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;

    @FindBy(className = "figcaption")
    public List<WebElement> figcaption;

    //Page Class Constructor
    public MouseHover(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void hoverOverImage(int index) {

        Actions action = new Actions(driver);

        action.moveToElement(images.get(index)).build().perform();

    }

    public String getVisibleContent(int index) {

        return figcaption.get(index).getText();
    }
    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/hovers");
    }
}
