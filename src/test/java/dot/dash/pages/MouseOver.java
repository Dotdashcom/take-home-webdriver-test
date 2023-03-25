package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MouseOver {
    public MouseOver() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public int numberOfImages(){
        return Driver.getDriver().findElements(By.xpath("//div[@class='figure']")).size();
    }

    public WebElement images(int index){
    return Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])["+index+"]"));
    }
       public List<WebElement> infos(int index){
        List<WebElement> list = new ArrayList<>();
           WebElement name = Driver.getDriver().findElement(By.xpath("(//div[@class='figcaption'])[" + index + "]//h5"));

           WebElement profile = Driver.getDriver().findElement(By.xpath("(//div[@class='figcaption'])[" + index + "]//a"));
           list.addAll(List.of(name,profile));
           return list;
       }


}
