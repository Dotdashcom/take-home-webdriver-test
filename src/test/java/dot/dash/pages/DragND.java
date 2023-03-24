package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DragND {

    public WebElement element(String str){
        return Driver.getDriver().findElement(By.id("column-"+str));
    }

}
