package pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailTextBox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordTextBox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement selectCheckBox() {
        return driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    }

    public WebElement dragElementA() {
        return driver.findElement(By.xpath("//div[@id='column-a']"));
    }

    public WebElement dragElementB() {
        return driver.findElement(By.xpath("//div[@id='column-b']"));
    }

    public WebElement removeBtn() {
        return driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
    }

    public WebElement selectDropDown() {
        return driver.findElement(By.id("dropdown"));
    }

    public WebElement contextMenu() {
        return driver.findElement(By.id("hot-spot"));
    }

    public WebElement firstContent() {
        return driver.findElement(By.xpath("(//div[@class='row'])[4]"));

    }

    public WebElement enableBtn() {
        return driver.findElement(By.xpath("//button[@onclick='swapInput()']"));

    }

    public WebElement clickLinkTab() {
        return driver.findElement(By.xpath("//a[@href='/windows/new']"));

    }

    public WebElement frameLink() {
        return driver.findElement(By.linkText("Frames"));
    }

    public WebElement iFrameLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'iFrame')]"));
    }

    public WebElement frameElement() {
        return driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
    }

    public WebElement body() {
        return driver.findElement(By.id("tinymce"));
    }

    public WebElement alertsLink() {
        return driver.findElement(By.linkText("JavaScript Alerts"));
    }

    public WebElement jsAlertBtn() {
        return driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    }

    public WebElement jsConfirmBtn() {
        return driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    }

    public WebElement jsPromptBtn() {
        return driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    }


    public void launchApplication(String url) {

        driver.get(url);
        driver.manage().window().maximize();
    }

    public void login(String email, String password) {

        getEmailTextBox().sendKeys(email);
        getPasswordTextBox().sendKeys(password);
        getLoginButton().click();

    }

    public void loginSuccess() {
        Assert.assertTrue(getSuccessMessage().getText().contains("You logged into a secure area!"));

    }

    public void loginFailure() {
        Assert.assertTrue(getSuccessMessage().getText().contains("Your password is invalid!"));

    }

    public void clickCheckBox() {
        selectCheckBox().click();

    }

    public void validateCheckBoxSelected() {
        Assert.assertTrue(selectCheckBox().isSelected());
        System.out.println("Select checkbox");
    }

    public void validateCheckBoxUnSelected() {
        Assert.assertTrue(!selectCheckBox().isSelected());
        System.out.println("Select checkbox");
    }

    public void clickContextMenu() {
        Actions a = new Actions(driver);
        a.contextClick(contextMenu()).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
    }

    public void dragAndDrop() {

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(dragElementA())
                .moveToElement(dragElementB())
                .release(dragElementB())
                .build();
        dragAndDrop.perform();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='column-b']//header")).getText(), "A");
    }


    public void dropDown() {

        Select select = new Select(selectDropDown());
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

    }


    public void dynamicContent() {

        String firstTimeText = firstContent().getText();
        driver.navigate().refresh();
        String secondTimeText = firstContent().getText();

        if (firstTimeText.equals(secondTimeText)) {
            System.out.println("Page didn't refresh properly.");
        } else {
            System.out.println("Yes, content is changed after refresh");
        }
    }


    public void clickRemove() {
        removeBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");
    }

    public void clickAdd() {
        removeBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(driver.findElement(By.xpath("(//form[@id='checkbox-example']/div)[1]")).getText().trim().contains("A checkbox"));
    }

    public void clickEnable() {
        enableBtn().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
        Assert.assertTrue(enableBtn().getText().trim().contains("Disable"));
    }

    public void clickTabLink() {
        clickLinkTab().click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='example'] h3")).getText().trim().equals("New Window"));
    }

    public Void enterFrame() {

        frameLink().click();
        iFrameLink().click();
        driver.switchTo().frame("mce_0_ifr");
        String expText = "Your content goes here.";
        String actText = body().getText();
        ;
        Assert.assertEquals(actText, expText);
        return this.enterFrame();
    }

    public void clickOnJSAlert() {
        alertsLink().click();
    }

    public String clickOnJSAlertBtn() {

        jsAlertBtn().click();
        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        //al.accept();
        return al.getText();
    }

    public String clickOnJSconfirmBtn() {

        jsConfirmBtn().click();
        Alert al = driver.switchTo().alert();
        System.out.println(al.getText());
        //al.dismiss();
        return al.getText();
    }

    public String clickOnJSPromptBtn() {

        jsPromptBtn().click();
        Alert al = driver.switchTo().alert();
        al.sendKeys("JSPromptAlert");
        System.out.println(al.getText());
        return al.getText();
    }
}

