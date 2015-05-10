package ua.artcode.week3.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 10.05.15.
 */
public class TestJoin {
    public static void main(String[] args) {
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(worker);
            workers.add(th);
            th.start();
        }


        // waiting workers
        for(Thread t : workers){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("finish work");


    }


}

