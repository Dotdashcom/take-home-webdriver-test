package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FloatingMenuPage {
    public FloatingMenuPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//div[@id='menu']")
    private WebElement menu;

    public void FloatingMenu() {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.GetDriver());
        javascriptExecutor.executeScript("window.scrollBy(0,2000)");
        if(menu.isDisplayed()){
            System.out.println("Menu is displayed");
        }else{
            System.out.println("Menu is not displayed");
        }
        List<WebElement> menuList = Driver.GetDriver().findElements(By.xpath("(//div[@id='menu'])//ul//li"));
        for(WebElement each: menuList){
            System.out.println(each.getText());
        }

    }

}
