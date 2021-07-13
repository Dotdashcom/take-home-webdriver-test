package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlPage extends PageObject {

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Remove')]")
    private WebElement btnRemove;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    private WebElement btnAdd;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Enable')]")
    private WebElement btnEnable;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Disable')]")
    private WebElement btnDisable;

    @FindBy(how = How.XPATH, using = "//p[@id='message']")
    private WebElement message;

    private WebDriverWait wait = new WebDriverWait(driver, 30);

    public DynamicControlPage(WebDriver driver) {
        super(driver);
    }

    public void clickRemoveCheckboxButton() {
        btnRemove.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's gone!"));
    }

    public void clickAddCheckboxButton() {
        wait.until(ExpectedConditions.visibilityOf(btnAdd));
        btnAdd.click();
    }

    public void clickEnableButton() {
        btnEnable.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's enabled!"));
    }

    public void clickDisableButton() {
        wait.until(ExpectedConditions.visibilityOf(btnDisable));
        btnDisable.click();
    }

    public String getMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        return driver.findElement(By.id("message")).getText();
    }
}
