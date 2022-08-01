package com.BostonBragg.TakeHomeWebDriverTest.utils;

import java.util.ArrayList;

public class MiscUtils {
    public static boolean checkIfAnyElementsInListAreTheSame(ArrayList<String> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
