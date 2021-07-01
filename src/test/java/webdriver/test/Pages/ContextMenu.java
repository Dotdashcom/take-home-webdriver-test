package webdriver.test.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

public class ContextMenu {

    //local webdriver variable
    private WebDriver driver;


    @FindBy(id = "hot-spot")
    private WebElement contextMenu;

    //Page Class Constructor
    public ContextMenu(WebDriver driver) {

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }


    public void rightClickContextMenu() {
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu).perform();
    }

    //Alert Action


    public String getAlertMenuText() throws NoAlertPresentException {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlertMenu() throws NoAlertPresentException {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/context_menu");
    }
}
