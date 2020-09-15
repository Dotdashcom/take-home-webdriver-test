package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingTypesPage {
    WebDriver driver;

    public DynamicLoadingTypesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text() ='Example 2: Element rendered after the fact']")
    WebElement exampleTwo;

    public void clickExampleTwo(){ exampleTwo.click(); }
}
