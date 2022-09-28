package com.dotdash.mkb.utilities;

import java.awt.*;
import java.awt.event.KeyEvent;


public class RoboUtils {

    private static Robot robot = null;

    // Restrict creating objects on the fly.
    private RoboUtils() {

    }

    public static Robot createRobot() {
        if(robot != null) {
            return robot;
        }

        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.out.println("Robot creation failed. " + e.getMessage() );
        }
        return robot;
    }

    public static void pressEsace() {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}
