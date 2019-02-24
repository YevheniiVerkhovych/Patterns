package SingletonePattern;

public class R implements Runnable {

    @Override
    public void run() {
        Singletone.getInstance();
    }

}
