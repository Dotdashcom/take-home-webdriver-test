package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import task.pages.MouseHoverPage;
import task.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class MouseHover {

    MouseHoverPage mouseHoverPage = new MouseHoverPage();

   List<String> expectedTexts = new ArrayList<>();



    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/hovers");
    }



    @Test
    public void testMouseHover() {

        List<WebElement> allImages = mouseHoverPage.images; // get all images


        //loop and hover over each
        //hover over 1st image

        expectedTexts.add("name: user1");
        expectedTexts.add("name: user2");
        expectedTexts.add("name: user3");


        for (int i = 0; i < expectedTexts.size(); i++) {

            String actualText = mouseHoverPage.hoverOver(allImages, i);

            Assertions.assertEquals(expectedTexts.get(i), actualText);



        }
    }






        @AfterEach
        public void tearDown() {
            Driver.closeDriver();
        }

    }