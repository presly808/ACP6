package ua.artcode.week3.day2;

public class TestSleep {

    public static void main(String[] args) {
        MySchedulerThread runnable = new MySchedulerThread();
        Thread th1 = new Thread(runnable);
        th1.start();
    }


}
class MySchedulerThread implements Runnable {

    @Override
    public void run() {
        while(true){
            Thread th = Thread.currentThread();
            System.out.printf("id %d, name %s, message %s\n",
                    th.getId(), th.getName(), "time action");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}