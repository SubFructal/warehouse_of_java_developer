package ru.sendgoods.saburov.warehouse_of_java_developer.part_24;

import java.util.concurrent.TimeUnit;

public class Starter {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("Start %s with id = %d\n",
                Thread.currentThread().getName(), Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(2);
        Thread thread1 = new MyThread();
        thread1.join();
        TimeUnit.SECONDS.sleep(2);
//        Thread.sleep(1000);
        Thread thread2 = new MyThread();
        thread2.join();
        TimeUnit.SECONDS.sleep(2);
//        Thread.sleep(1000);
        Thread thread3 = new MyThread();
        thread3.join();
        TimeUnit.SECONDS.sleep(2);

        for(int i = 0; i < 5; i++) {
            Thread t = new Thread(new MyRunnableImpl());
            t.start();
        }

        Thread.sleep(5000);
        System.out.printf("Finish %s with id = %d\n",
                Thread.currentThread().getName(), Thread.currentThread().getId());

    }
}


class MyThread extends Thread {

    public MyThread() {
        this.start();
    }

    @Override
    public void run() {
        System.out.printf("Start %s with id = %d\n", this.getName(), this.getId());
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.printf("Finish %s with id = %d\n", this.getName(), this.getId());

    }
}

class MyRunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.printf("Start Runnable %s with id = %d\n",
                Thread.currentThread().getName(), Thread.currentThread().getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.printf("Finish Runnable %s with id = %d\n",
                Thread.currentThread().getName(), Thread.currentThread().getId());

    }
}