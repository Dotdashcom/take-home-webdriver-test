package Pages;


import Utils.Driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageBase {
    static WebDriver driver = Driver.getDriver("chrome");

    public PageBase (){
        PageFactory.initElements(driver,this);
    }

    public void goToPage(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void refreshPage(){
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void tearDown(){ driver.quit();}
}
