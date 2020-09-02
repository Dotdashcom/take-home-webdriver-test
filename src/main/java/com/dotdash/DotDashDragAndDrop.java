package com.dotdash;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashDragAndDrop extends BaseAPI {

    @FindBy(how = How.CSS, using = pointAID)
    public WebElement getPointA;
    @FindBy(how = How.CSS, using = pointBID)
    public WebElement pointB;

    // Page Factory
    static DotDashDragAndDrop dragDrop;

    public static void initPage() {
        dragDrop = PageFactory.initElements(driver, DotDashDragAndDrop.class);
    }

    // Drag element A into element B
    public static void dragPointAToB() {
        initPage();
        implicitWait(3000);
        try {
            dragNDrop(dragDrop.getPointA, dragDrop.pointB);
            System.out.println("Element dragged and dropped as expected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void navigateToDragNDrop() {
        driver.get(baseURL + "drag_and_drop");
    }
}
