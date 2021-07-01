package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

public class DynamicContent {

    //local webdriver variable
    private WebDriver driver;




    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    WebElement dynamicContent1;

    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]")
    WebElement dynamicContent2;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]")
    WebElement dynamicContent3;



    //Page Class Constructor
    public DynamicContent(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }

    public String getDynamicContent1() {
        return dynamicContent1.getText();

    }
    public String getDynamicContent2() {
        return dynamicContent2.getText();

    }
    public String getDynamicContent3() {
        return dynamicContent3.getText();

    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/dynamic_content");
    }
}
