package ua.artcode.week3.day2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by serhii on 10.05.15.
 */
public class BankAccountManagment {

    public static void main(String[] args) {
        BankAccount someAccount = new BankAccount(0);


        for (int i = 0; i < 8; i++) {
            new Thread(new BankAccountProducer(someAccount)).start();
            new Thread(new BankAccountConsumer(someAccount)).start();
        }


    }
}


class BankAccountConsumer implements Runnable {

    public static final int COUNT = 1000;
    private BankAccount someThreadAccount;

    public BankAccountConsumer(BankAccount someThreadAccount) {
        this.someThreadAccount = someThreadAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            someThreadAccount.withdraw(1000);
        }
    }
}


class BankAccountProducer implements Runnable {
    public static final int COUNT = 1000;
    private BankAccount someThreadAccount;

    public BankAccountProducer(BankAccount someThreadAccount) {
        this.someThreadAccount = someThreadAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            someThreadAccount.put(1000);
        }
    }
}

class BankAccount {

    private int cash;

    public BankAccount(int cash) {
        this.cash = cash;
    }

    public synchronized void put(int money){ // monit is this
        showThreadInfo("put get monitor");
        while(cash != 0){
            try {
                showThreadInfo("put go sleep");
                this.wait();
                showThreadInfo("put awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cash = cash + money;
        showThreadInfo("put return monitor");
        this.notifyAll();
    }

    public int withdraw(int money){
        synchronized (this){
            showThreadInfo("withdraw get monitor");
            while(cash - money < 0){
                try {
                    showThreadInfo("withdraw sleep");
                    this.wait();
                    showThreadInfo("withdraw awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cash = cash - money;
            showThreadInfo("withdraw get monitor");
            this.notifyAll();
            return money;
        }
    }

    public int getCash() {
        return cash;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }

    public void showThreadInfo(String operation){
        Thread t = Thread.currentThread();
        System.out.printf("id %d, name %s, operation %s, cash %d\n",
                t.getId(),t.getName(),operation,cash);
    }
}

