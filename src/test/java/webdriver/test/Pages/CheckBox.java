package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

public class CheckBox {

    //local webdriver variable
    private WebDriver driver;



    @FindBy(xpath="//input[@type='checkbox'][1]")
    public WebElement checkBoxOne;

    @FindBy(xpath="//input[@type='checkbox'][2]")
    public WebElement checkBoxIwo;

    @FindBy(xpath="//input[@type='checkbox']")
    public WebElement checkBoxAll;


    //Page Class Constructor
    public CheckBox(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/checkboxes");
    }
}
