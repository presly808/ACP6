package ua.artcode.week3.day2;

/**
 * Created by serhii on 10.05.15.
 */
public class StopThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SomeThread());
        t1.start();


        Thread.sleep(4000);
        t1.interrupt();


    }

}


class SomeThread implements Runnable {

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            Thread th = Thread.currentThread();
            System.out.println("start sequence");
            for (int i = 0; i < 10; i++) {
                System.out.printf("id %d, name %s, operation %s\n",
                        th.getId(), th.getName(), i);
                try {
                    Thread.sleep(58);
                } catch (InterruptedException e) {
                    th.interrupt();
                }
            }
            System.out.println("end of operations sequence");
        }

    }
}

