package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends CommonApi {

    WebDriver driver;
    public DragAndDropPage( WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='columns']//div[@id='column-a']")
    WebElement boxA;
    @FindBy(xpath = "//div[@id='columns']//div[@id='column-b']")
    WebElement boxB;


    public void dragBoxAToBoxB(){
        Actions action=new Actions(driver);
        action.dragAndDrop(boxB,boxA).build().perform();
    }
    public String getTextBoxA() {
        String textA = boxA.getText();
        return textA;
    }

        public String getTextBoxB(){
            String textB= boxB.getText();
            return textB;

    }

    public void goTo(){
        driver.get(" http://localhost:7080/drag_and_drop");
    }





}
