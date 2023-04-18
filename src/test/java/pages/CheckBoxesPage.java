package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage {

    private WebDriver driver;

    public static final String url = "/checkboxes";

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckBox1() {
        driver.findElement(By.cssSelector("input:nth-of-type(1)")).click();
    }

    public void clickCheckBox2() {
        driver.findElement(By.cssSelector("input:nth-of-type(2)")).click();
    }

    public boolean checkbox1IsSelected() {
        return driver.findElement(By.cssSelector("input:nth-of-type(1)")).isSelected();
    }

    public boolean checkbox2IsSelected() {
        return driver.findElement(By.cssSelector("input:nth-of-type(2)")).isSelected();
    }
}
