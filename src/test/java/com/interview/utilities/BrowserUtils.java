package com.interview.utilities;

public class BrowserUtils {


    public static  void sleep(int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println("something happened in sleep method");
        }
    }

}
