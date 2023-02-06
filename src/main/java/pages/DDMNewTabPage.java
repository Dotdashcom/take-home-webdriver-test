package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;

public class DDMNewTabPage extends DDMBasePage  {

    @FindBy(css = "div.example a")
    protected WebElement clickHereButton;
    @FindBy(css = "div.example h3")
    protected WebElement newWindowTitle;

    public DDMNewTabPage(WebDriver driver)  {
        super(driver);
    }

    public void openNewTabAndSwitch()  {
        clickHereButton.click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    public String getNewWindowText()  {
        return newWindowTitle.getText();
    }
}