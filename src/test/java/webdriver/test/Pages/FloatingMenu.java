package webdriver.test.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;


public class FloatingMenu {

    //local webdriver variable
    private WebDriver driver;



    @FindBy(css = "a[href='#home']")
    public WebElement floatingMenuHomeLink;

    @FindBy(id = "menu")
    public WebElement floatingMenuDiv;

    //Page Class Constructor
    public FloatingMenu(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void scrollToPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/floating_menu");
    }
}
