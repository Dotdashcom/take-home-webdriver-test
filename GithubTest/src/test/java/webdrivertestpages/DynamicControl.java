package webdrivertestpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControl {
    WebDriver driver;


    public DynamicControl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dynamicControl() {

        // To do the checkbox, first I locate the element and then I invoked the click() method
        WebElement element = driver.findElement(By.xpath("//div[@id='checkbox']//input"));
        element.click();

        /*
         * I am using explicit wait here so that the driver is directed to wait until certain
         * condition occurs before proceeding with executing the code.
         * So, basically I am teling the webdriver to wait until visibility of element has been located.
         * For WebDriverWait first we are instantiating the class and we are passing the driver and
         * the wait time as parameter to its constructor.
         * Then I am using the visibilityOfElementLocated expected condition.
         * */
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();

        //I am using explicit wait here to handle a specific webElement named "Enable"
        WebDriverWait wait1 = new WebDriverWait(driver,30);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();

    }


}

