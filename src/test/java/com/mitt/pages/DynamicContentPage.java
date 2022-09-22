package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class DynamicContentPage extends BasePage {

    private final String[] images = {"http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg"};
    private final String[] contents = {"Dicta et nemo maxime voluptatem dolor vitae inventore voluptatum minus voluptatem qui ipsum quo doloremque perspiciatis non autem quia veritatis quis ipsa enim dignissimos occaecati qui voluptates assumenda iure aut praesentium.","Et rerum corporis expedita eligendi quidem est suscipit eum quaerat rerum magni aut sequi ipsa iste quae quas sint maiores omnis beatae nobis quia mollitia non ut eos facilis magnam.","Dicta et nemo maxime voluptatem dolor vitae inventore voluptatum minus voluptatem qui ipsum quo doloremque perspiciatis non autem quia veritatis quis ipsa enim dignissimos occaecati qui voluptates assumenda iure aut praesentium.","Sint aperiam minus dolorem numquam sed perspiciatis aliquid et eum natus voluptatem eius eaque earum fugiat ipsam corporis placeat illo molestiae eos explicabo odio maxime unde omnis voluptas non quos commodi."
            ,"Rerum velit et enim incidunt nobis tempore facere est est eveniet perspiciatis saepe fugit veniam nihil ipsum nemo eum et repellat et nisi laboriosam optio et consequuntur rerum et et adipisci nihil sit."};
    private final By image = By.xpath("//*[@id='content']/div[1]/div[1]/img");
    private final By content = By.xpath("/*[@id='content']/div[1]/div[2]");

    public DynamicContentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("dynamic_url"));
    }

    public void dynamicContentVerification(){
        AtomicBoolean isPass = new AtomicBoolean(false);

        IntStream.range(0, images.length).forEach(i ->{

            getDriver().navigate().refresh();

            if(images[i] == findElement(image).getAttribute("src")
                && contents[i] == findElement(content).getText() )  isPass.set(true);

            else isPass.set(false);

        });

        Assert.assertEquals(false, isPass.get());
    }
}
