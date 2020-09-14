package webdrivertestpages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading extends Base {
    WebDriver driver;
    By element1 = By.xpath("\"//button[contains(text(),'Start')]\"");
    By element2 = By.xpath("//h4[contains(text(),'Hello World!')]");

    String text;

    public DynamicLoading(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dynamicLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element1));

    }

    public String getTxt(){
            return text;
        }
}


