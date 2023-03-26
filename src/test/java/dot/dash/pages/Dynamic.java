package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Dynamic {

    private int numberOfParagraphs(){
       return Driver.getDriver().findElements(By.xpath("((//div[@id='content'])[2]//div[@class='large-10 columns'] )")).size();
    }

    public WebElement getParagraph(int index){
       return Driver.getDriver().findElement(By.xpath("((//div[@id='content'])[2]//div[@class='large-10 columns'] )["+index+"]"));
    }

    public List<String> listOfTexts(){
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= numberOfParagraphs(); i++) {
            list.add(getParagraph(i).getText());
        }
        return list;
    }

}
