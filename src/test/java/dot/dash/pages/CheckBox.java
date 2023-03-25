package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox {

    //I did not use constructor for this POM

    public WebElement checkB(int index) {
        return Driver.getDriver().findElement(By.xpath("(//input)[" + index + "]"));
    }
    public int numberOfCheckboxes() {
        return Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).size();
    }


}
