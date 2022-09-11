package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DragAndDrop {

    public DragAndDrop(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Drag and Drop")
    WebElement dragAndDrop;

    @FindBy(id = "column-a")
    WebElement draggableA;

    @FindBy(xpath = "//div[@id='column-b']")
    WebElement draggableB;

    @FindBy(xpath = "//div[@id='column-a']//header")
    WebElement headerA;

    public void dragAndDropA(WebDriver driver) throws InterruptedException {
        dragAndDrop.click();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableA,draggableB).perform();
        Thread.sleep(500);
        String expectedHeader = headerA.getText();


        Assert.assertEquals(expectedHeader,"A" );


    }

}
