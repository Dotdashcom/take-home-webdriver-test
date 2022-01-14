package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends PageGeneral {

    public CheckboxPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement checkboxButtonComponent(String i) {
        return this.driver.findElement(By.xpath("//input[@type='checkbox']["+ i +"]"));
    }

//    public WebElement checkbox2ButtonComponent() {
//        return this.webDriver.findElement(By.xpath("//input[@type='checkbox'][2]"));
//    }

}
