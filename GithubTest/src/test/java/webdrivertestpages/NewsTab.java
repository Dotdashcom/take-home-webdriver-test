package webdrivertestpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsTab {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement element;
    String newTabURL;

    public NewsTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public void newsTab () {
            String currentTabURL = driver.getCurrentUrl();
            System.out.println("Current Tab URL is : " + currentTabURL);
            element.click();
            // to open a new tab
            driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
            driver.get("http://localhost:7080/windows/new");
            newTabURL = driver.getCurrentUrl();
            System.out.println("New Tab URL is: " + newTabURL);
    }

    public String getNewTabURL(){
        return newTabURL;
    }

}
