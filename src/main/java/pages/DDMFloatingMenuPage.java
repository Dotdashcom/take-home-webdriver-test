package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DDMFloatingMenuPage extends DDMBasePage  {

    @FindBy(id = "menu")
    protected WebElement levelOneMenu;

    public DDMFloatingMenuPage(WebDriver driver)  {
        super(driver);
    }

    public void scrollByOnePage()  {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public boolean isFloatingMenuDisplayed()  {
        return levelOneMenu.isDisplayed();
    }
}