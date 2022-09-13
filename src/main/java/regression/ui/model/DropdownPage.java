package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class DropdownPage extends WebObject {
    public DropdownPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static DropdownPage navigateToDropdownPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/dropdown", baseUrl);
        driver.get(url);
        return new DropdownPage(driver);
    }

    public String getTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void clickDropdownField() {
        WebElement checkbox = driver.findElement(By.xpath(this.xpathForDropdown()));
            checkbox.click();
    }

    public void selectDropdownOption1() {
        int number = 1;
        WebElement option1 = driver.findElement(By.xpath(this.xpathForDropdownOption(number)));
        option1.click();
    }

    public void selectDropdownOption2() {
        int number = 2;
        WebElement option2 = driver.findElement(By.xpath(this.xpathForDropdownOption(number)));
        option2.click();
    }

    public boolean isDropdownOptionSelected(int index) {
        WebElement state = driver.findElement(By.xpath(this.xpathForDropdownOption(index)));
        return state.isSelected();
    }

    private String xpathForDropdown() {
        return "//*[@id=\"dropdown\"]";
    }

    private String xpathForDropdownOption(int number) {
        return String.format("//option[@value = %s]", number);
    }

    private String xpathForPageTitle() {
        return "//h3";
    }
}
