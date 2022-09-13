package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class DynamicControlsPage extends WebObject {

    public DynamicControlsPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static DynamicControlsPage navigateToDynamicControlsPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/dynamic_controls", baseUrl);
        driver.get(url);
        return new DynamicControlsPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public boolean isCheckboxVisible(){
        return this.doesElementExist(By.xpath(this.xpathForCheckBox()));
    }

    public DynamicControlsPage clickAddButton() throws Exception {
        String add = "Add";
        return this.clickButton(add);
    }

    public DynamicControlsPage clickRemoveButton() throws Exception {
        String remove = "Remove";
        return this.clickButton(remove);
    }

    public DynamicControlsPage clickEnableButton() throws Exception {
        String enable = "Enable";
        return this.clickButton(enable);
    }

    public DynamicControlsPage clickDisableButton() throws Exception {
        String disable = "Disable";
        return this.clickButton(disable);
    }

    private DynamicControlsPage clickButton(String buttonName) throws Exception {
        By buttonLocator = By.xpath(this.xpathForButton(buttonName));
        WebElement addButton = driver.findElement(buttonLocator);
        addButton.click();
        this.waitForElementInvisibility(buttonLocator);
        return this;
    }

    public boolean isTextBoxEnabled(){
      WebElement textBox  = driver.findElement(By.xpath(this.xpathForTextBox()));
      return textBox.isEnabled();
    }

    /**
     * Page has a bug and display breaks on the third consecutive click action on the page.
     * @return DynamicControlsPage
     */
    public DynamicControlsPage refreshPage(){
        this.refreshWebPage();
        return this;
    }

    private String xpathForCheckBox() {
        return "//input[@type=\"checkbox\"]";
    }

    private String xpathForPageTitle() {
        return "//h4";
    }

    private String xpathForButton(String text){
        return String.format("//button[text()= \"%s\"]", text);
    }

    private String xpathForTextBox(){
        return "//input[@type=\"text\"]";
    }
}
