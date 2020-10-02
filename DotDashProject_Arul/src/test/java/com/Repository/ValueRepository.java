package com.Repository;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ValueRepository extends PageInvocation{



    public static final String _baseUrl = "http://localhost:7080/";

    //Credentials
    public static final String _validUserName = "tomsmith";
    public static final String _validPassWord = "SuperSecretPassword!";
    public static final String _invalidUserName = "incorrectUsername";
    public static final String _invalidPassWord = "incorrectPassword";

    //Paths
    public static final String browserPath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Driver\\chromedriver.exe";
    public static final String downloadPath = System.getProperty("user.dir")+ "\\src\\test\\java\\com\\Downloads";

    public static final String JSfordraganddrop ="function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
            + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
            + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
            + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
            + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
            + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
            + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
            + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
            + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
            + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
            + "var dropEvent = createEvent('drop');\n"
            + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
            + "var dragEndEvent = createEvent('dragend');\n"
            + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
            + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
            + "simulateHTML5DragAndDrop(source,destination);";

}
