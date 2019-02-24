package SingletonePattern;
class Singletone {
    private static final Object sync = new Object();
    public static int counter = 0;
    private static volatile Singletone instance = null;

    private Singletone() {
        counter++;
    }

    public static Singletone getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new Singletone();
                    }
                }
            }
            return instance;
        }
    }

