package ua.artcode.week3.day2;

/**
 * Created by serhii on 10.05.15.
 */
public class TestSimpleThread {

    public static void main(String[] args) {

        for (int q = 0; q < 10; q++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }

        for (int i = 0; i < 10000; i++) {
            System.out.println("Main count " + i);
        }

    }
}

class MyThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.printf("id %d, name %s, count %d\n",
                    getId(), getName(), i);
        }
    }
}


