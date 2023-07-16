package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends CommonApi {
    WebDriver driver;
    public  DynamicContentPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='click here']")
    WebElement clickHereToRefresh;

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]")
    WebElement dynamicText;

    public void refrshThePage(){
        clickHereToRefresh.click();
    }

    public String getThirdText1(){
        String text1=dynamicText.getText();
        return text1;
    }
    public String getThirdText2(){
        String text2=dynamicText.getText();
        return text2;
    }

    public void goTo(){
        driver.get("http://localhost:7080/dynamic_content");
    }





}
