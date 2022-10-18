package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

import java.util.ArrayList;

public class DynamicContentPage {
    String clickHere="//a[text()='click here']";
    ArrayList<String> initialContent=new ArrayList<>();
    ArrayList<String> afterClickContent=new ArrayList<>();

    public void clickToChangeTextDynamically(){
        for(int i =1;i<4;i++){
        initialContent.add(I.amPerforming().getText("//div[@id='content']//div[@class='row']["+i+"]//div[@class='large-10 columns']"));
        }
        I.amPerforming().click(clickHere);
        for(int i =1;i<4;i++){
            afterClickContent.add(I.amPerforming().getText("//div[@id='content']//div[@class='row']["+i+"]//div[@class='large-10 columns']"));
        }
    }

    public void assertContentChangedDynamically(){
        boolean flag= false;
        for(int i =0;i<3;i++){
            if(!initialContent.get(i).equals(afterClickContent.get(i))) {
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);
        I.amPerforming().threadWait(5000);
    }

    public void clickOnStartButton(){
        I.amPerforming().click("//button[text()='Start']");
    }

    public void  assertDynamicElementDisplayed(String text){
        I.amPerforming().waitForElementToDisappear("//*[@id='loading']");
        Assert.assertEquals(I.amPerforming().getText("//div/*[text()='"+text+"']"),text);
    }
}
