package SingletonePattern;

class SingletoneAPP {

    public static void main(String[] args)  throws InterruptedException {
        final int SIZE =1000;
        Thread t[] = new Thread[SIZE];

        for(int i = 0; i < SIZE; i++) {

            t[i] = new Thread(new R());
            t[i].start();
        }

        for(int i = 0; i < SIZE; i++) {

            t[i].join();
        }

        System.out.println(Singletone.counter);

    }
}
