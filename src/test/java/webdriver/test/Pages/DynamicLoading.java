package webdriver.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.test.Util.PageLoader;



public class DynamicLoading {

    //local webdriver variable
    private WebDriver driver;


    @FindBy(css ="#start button")
    private WebElement startButton;

    @FindBy(id ="finish")
    private WebElement renderMessage;



    //Page Class Constructor
    public DynamicLoading(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void clickStartButton() {
        startButton.click();
    }

    public String getRenderMessage() {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        return renderMessage.getText();
    }



    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "dynamic_loading/2");
    }
}
