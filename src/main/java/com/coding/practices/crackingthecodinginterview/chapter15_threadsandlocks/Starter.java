package com.coding.practices.crackingthecodinginterview.chapter15_threadsandlocks;


class MyThread implements Runnable {
    int a = 0;

    @Override
    public void run() {
        int b = 0;
        a++;
        b++;
        System.out.println(a + " " + b);
    }
}

public class Starter {

    public static void main(String[] args) {
        MyThread obj = new MyThread();
        new Thread(obj).start();
        new Thread(obj).start();
        new Thread(obj).start();
        new Thread(obj).start();
    }
}
