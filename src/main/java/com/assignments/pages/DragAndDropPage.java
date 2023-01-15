package com.assignments.pages;

import org.openqa.selenium.By;
import static com.assignments.enums.WaitStrategy.VISIBLE;

public final class DragAndDropPage extends BasePage {
    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");
    private final By columnAText = By.xpath("//div[@id='column-a']/header");
    private final By columnBText = By.xpath("//div[@id='column-b']/header");

    public void dragAndDropAction() {
        String script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";

        javaScriptDragAndDrop(script, scrollIntoElement(columnA, VISIBLE), scrollIntoElement(columnB, VISIBLE));

    }

    public String getElementAText() {
        return getText(columnAText, VISIBLE, "Column A Text");
    }
    public String getElementBText() {
        return getText(columnBText, VISIBLE, "Column B Text");
    }
}
