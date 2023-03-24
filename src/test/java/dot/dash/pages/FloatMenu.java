package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FloatMenu {
   public List<WebElement> menus(){
       return Driver.getDriver().findElements(By.cssSelector("#menu > ul > li > a"));
   }

}
