package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadFile
{
    WebDriver driver;


    public DownloadFile(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }

    WebElement dwnfil= driver.findElement(By.linkText("WebElement dwnfil"));


    public WebElement download()
    {
        return dwnfil;
    }

}
