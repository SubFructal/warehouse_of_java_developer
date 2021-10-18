package ru.sendgoods.saburov.warehouse_of_java_developer.part_25;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
//            System.out.println("Start Runnable: " + Thread.currentThread().getId());
            System.out.println("Start Runnable: " + Thread.currentThread().getName());
//            System.out.println("Start Runnable: " + Thread.currentThread().getClass().getSimpleName());
            Thread.sleep(5000);
//            System.out.println("Finish Runnable: " + Thread.currentThread().getId());
            System.out.println("Finish Runnable: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}