package library;

import java.io.File;

public class JavaLibrary
{
    public boolean isFileDownloaded(String filePath) throws Exception {
        final int SLEEP_TIME_MILLIS = 1000;
        File file = new File(filePath);
        final int timeout = 60* SLEEP_TIME_MILLIS;
        int timeElapsed = 0;
        while (timeElapsed<timeout){
            if (file.exists()) {
                System.out.println( "the file  is present");
                return true;
            } else {
                timeElapsed +=SLEEP_TIME_MILLIS;
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        }
        return false;
    }
}
