package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {
    WebDriver driver;

    String checkboxesUrl = ("http://localhost:7080/checkboxes");
    String checkbox1Xpath ="//input[@type='checkbox'][1]";
    String checkbox2Xpath ="//input[@type='checkbox'][2]";


    public CheckboxesPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(checkboxesUrl);
    }

    public void click(){
        WebElement checkbox1 = driver.findElement(By.xpath(checkbox1Xpath));
        checkbox1.click();

    }

    public void unclick(){
        WebElement checkbox2 = driver.findElement(By.xpath(checkbox2Xpath));
        checkbox2.click();

    }

    public boolean checkBox1IsSelected(){
        WebElement checkbox1 = driver.findElement(By.xpath(checkbox1Xpath));
        return checkbox1.isSelected();
    }

    public boolean checkBox2IsSelected(){
        WebElement checkbox2 = driver.findElement(By.xpath(checkbox2Xpath));
        return checkbox2.isSelected();
    }


}
