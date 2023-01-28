package utilities;

public class Utilities {

    public static int generalRandomNumber(int min, int max){

        int random=(int)(Math.random()*((max-min)+1)+min);
        return random;
    }
}
