package webdrivertestpages;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContent extends Base {
    WebDriver  driver;
    String content1;
    String content2;
    @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
    WebElement element;

    public DynamicContent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean dynamicContent(){

        content1  = element.getText();
        System.out.println("Before refresh the page: " + content1);
        driver.navigate().refresh();
        content2 = element.getText();
        System.out.println("After refresh the page: " + content2);

        if(!content1.equals(content2)){
            return true;
        }
        return false;
    }
}
