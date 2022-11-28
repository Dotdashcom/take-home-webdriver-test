package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {

    WebDriver driver;

    //Constructor
    public SecurePage(WebDriver driver) {
        this.driver=driver;
    }

    By heading = By.cssSelector("h2");
    By logoutBtn = By.className("radius");

    public String getHeading() {
        String head = driver.findElement(heading).getText();
        return head;
    }

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
