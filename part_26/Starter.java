package ru.sendgoods.saburov.warehouse_of_java_developer.part_26;

import java.util.concurrent.*;

public class Starter {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(5);
//        es.execute(new MyRunnable());
//        Future<?> subRun = es.submit(new MyRunnable());

//        while (!subRun.isDone()) {
//            System.out.println("Is not done");
//            TimeUnit.SECONDS.sleep(1);
//        }

        Future<Integer> subCall = es.submit(new MyCallable());
        TimeUnit.SECONDS.sleep(1);
        subCall.cancel(true);
        System.out.println(subCall.isCancelled());
//        Integer number = subCall.get();
//        System.out.println(number);


        System.out.println("Shutdown");
        es.shutdown();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Started: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Finished: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("Started: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Finished: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return 99;
    }
}