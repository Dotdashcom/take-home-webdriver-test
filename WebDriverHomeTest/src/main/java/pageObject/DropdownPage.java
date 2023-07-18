package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DropdownPage extends CommonApi {
    WebDriver driver;
    public DropdownPage( WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "dropdown")
    WebElement dropdownMenu;


    public void selectOption1() throws InterruptedException {
        Select se=new Select(dropdownMenu);
        Thread.sleep(2000);
        se.selectByValue("1");
    }
    public void selectOption2() throws InterruptedException {
        Select se=new Select(dropdownMenu);
        Thread.sleep(2000);
        se.selectByValue("2");
    }
    public String getTextOption1() {
        Select select = new Select(dropdownMenu);
        return select.getFirstSelectedOption().getText();

    }
    public String getTextOption2() {
        Select select = new Select(dropdownMenu);
        return select.getFirstSelectedOption().getText();

    }
    public void goTo(){
        driver.get(" http://localhost:7080/dropdown");
    }
}

