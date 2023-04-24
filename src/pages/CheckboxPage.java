package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage extends BasePage {
    private String path = "/checkboxes";

    private By checkbox1By = By.xpath("//form[@id='checkboxes']/input[1]");
    private By checkbox2By = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickCheckbox1() {
        driver.findElement(checkbox1By).click();
    }

    public void clickCheckbox2() {
        driver.findElement(checkbox2By).click();
    }

    public boolean checkbox1IsChecked() {
        return driver.findElement(checkbox1By).isSelected();
    }

    public boolean checkbox2IsChecked() {
        return driver.findElement(checkbox2By).isSelected();
    }
}
