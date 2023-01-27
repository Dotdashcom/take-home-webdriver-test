package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDrop {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DragAndDrop(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="column-a")
    private WebElement elementA;

    @FindBy(xpath = "//div[@id='column-a']/header")
    private WebElement textElementA;

    @FindBy(xpath = "//div[@id='column-b']/header")
    private WebElement textElementB;

    @FindBy(id="column-b")
    private WebElement elementB;



    public void verifyDragAndDropFunctionality() throws InterruptedException {
        navigateDragAndDrop();
        Actions builder = new Actions(driver);
        //builder.clickAndHold(textElementA).moveToElement(elementB).release(elementB).build().perform();
        System.out.println(elementB.getText());
        Thread.sleep(2000);

        builder.dragAndDrop(textElementA,elementB).perform();
        Thread.sleep(2000);

        softAssert.assertTrue(textElementB.getText().equalsIgnoreCase("A"), "The item didn't dragged and drop");

    }
    private void navigateDragAndDrop(){
        driver.get(ConfigReader.getProperty("url")+"/drag_and_drop");
    }
}
