package pages;
import com.google.sitebricks.client.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DragAndDropPage {

    public WebDriver driver;

    @FindBy(id = "column-a")
    public WebElement column_A;

    @FindBy(xpath ="//*[@id=\"column-a\"]/header")
    public WebElement header_ColumnA;

    @FindBy(id = "column-b")
    public WebElement column_B;

    @FindBy(xpath ="//*[@id=\"column-b\"]/header")
    public WebElement header_ColumnB;

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyDragAndDropFun(){
        if(column_A.isDisplayed()&&column_B.isDisplayed()){
            Actions actions = new Actions(driver);
            actions.dragAndDrop(column_A,column_B).perform();
            Assert.assertTrue(header_ColumnA.getAttribute("text").equalsIgnoreCase("B")&&
            header_ColumnB.getAttribute("text").equalsIgnoreCase("A"),"Drag and drop not worked as expected");
        }
    }

}
