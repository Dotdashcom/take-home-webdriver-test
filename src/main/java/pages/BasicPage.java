package pages;

public class BasicPage {
    public void wait(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
