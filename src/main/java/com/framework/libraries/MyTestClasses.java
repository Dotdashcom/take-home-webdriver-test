package com.framework.libraries;

import java.util.HashMap;
import java.util.Map;

public class MyTestClasses {
    private static boolean testStart=false;
    private static Map<Class<?>,Object> manageInstance=new HashMap<Class<?>,Object>();

    public static <T> T getObject(Class<T> className) {
        if(!testStart) {
            manageInstance.put(BrowserInteractions.class,new BrowserInteractions());
            testStart=true;
        }
        if(!manageInstance.containsKey(className)) {
            try {
                manageInstance.put(className,Class.forName(className.getName()).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return className.cast(manageInstance.get(className));
    }


    public static void closeAllClasses(){
        getObject(BrowserBucket.class).getDriver().quit();
        manageInstance.clear();
    }
}
