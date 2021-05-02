package com.trudova.getInProj.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtility {
    /* sleep method comes for java for temporary use */
    public static void sleep(int seconds){
        seconds*=1000;
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    public static List<String> translateToStrList(List<WebElement> list){
        List<String> strList = new ArrayList<>();
        for (WebElement element : list) {
            strList.add(element.getText());
        }
        return strList;
    }

}

