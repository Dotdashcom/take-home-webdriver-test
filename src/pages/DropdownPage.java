import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DropdownPage extends BasePage {
    private String path = "/dropdown";

    private By dropdownBy = By.xpath("//select[@id='dropdown']");
    private By selectedOptionBy = By.xpath("//select[@id='dropdown']/option[@selected='selected']");
    private String partialOptionXpath = "//select[@id='dropdown']/option";
    private Alert contextAlert;

    DropdownPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickDropdown() {
        driver.findElement(dropdownBy).click();
    }

    public void clickOption(int optionNum) {
        WebElement option = driver.findElement(By.xpath(partialOptionXpath+"["+optionNum+"]"));
        option.click();
    }

    public void clickOption(String optionText) {
        WebElement option = driver.findElement(By.xpath(partialOptionXpath+"[contains(text(), '"+optionText+"')]"));
        option.click();
    }

    public WebElement getSelectedOption() {
        return driver.findElement(selectedOptionBy);
    }
}
