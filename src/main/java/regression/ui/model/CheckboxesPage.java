package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class CheckboxesPage extends WebObject {
    public CheckboxesPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static CheckboxesPage navigateToCheckBoxPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/checkboxes", baseUrl);
        driver.get(url);
        return new CheckboxesPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void selectCheckbox(int index){
        WebElement checkbox = driver.findElement(By.xpath(this.xpathForCheckBox(index)));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }

    public void deSelectCheckbox(int index){
        WebElement checkbox = driver.findElement(By.xpath(this.xpathForCheckBox(index)));
        if(checkbox.isSelected()){
            checkbox.click();
        }
    }

    public boolean isCheckboxSelected(int index){
        WebElement checkbox = driver.findElement(By.xpath(this.xpathForCheckBox(index)));
        return checkbox.isSelected();
    }

    private String xpathForCheckBox(int index) {
        return String.format("//input[@type=\"checkbox\"][%s]", index);
    }

    private String xpathForPageTitle() {
        return "//h3";
    }
}
