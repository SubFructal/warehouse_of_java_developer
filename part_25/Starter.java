package ru.sendgoods.saburov.warehouse_of_java_developer.part_25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
Executors.newWorkStealingPool() - создает пул потоков, требующих трудозатрат, используя количество доступных
                                  процессоров в качестве целевого уровня параллелизма (создает количество трэдов,
                                  равное количеству ядер процессора данного компьютера).

Executors.newFixedThreadPool​(int nThreads, ThreadFactory threadFactory) - создает пул потоков, который повторно
использует фиксированное количество потоков, работающих в общей неограниченной очереди, используя предоставленный
ThreadFactory для создания новых потоков при необходимости. В любой момент не более nThreads потоков будут активными
задачами обработки. Если дополнительные задачи отправляются, когда все потоки активны, они будут ждать в очереди,
пока поток не станет доступным. Если какой-либо поток завершается из-за сбоя во время выполнения перед завершением
работы, новый поток займет его место, если это необходимо для выполнения последующих задач. Потоки в пуле будут
существовать до тех пор, пока это не будет явным образом shutdown.

public interface ThreadFactory - объект, который создает новые потоки по запросу. Использование фабрик потоков
устраняет жесткую привязку вызовов к new Thread, позволяя приложениям использовать специальные подклассы потоков,
приоритеты и т.д. (см. пример ниже)
 */

public class Starter {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newWorkStealingPool();

        ExecutorService executorService4 = Executors.newFixedThreadPool(10, new MyFactory());


//        for (int i = 0; i < 30; i++) {
//            executorService.submit(new MyRunnable());
//        }

//        for (int i = 0; i < 20; i++) {
//            executorService1.submit(new MyRunnable());
//        }

//        for (int i = 0; i < 3; i++) {
//            executorService2.submit(new MyRunnable());
//        }

//        for (int i = 0; i < 30; i++) {
//            executorService3.submit(new MyRunnable());
//        }
//        executorService3.awaitTermination(20, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            executorService4.submit(new MyRunnable());
        }
        executorService4.shutdown();

    }
}

// Будут создаваться не стандартные трэды типа Thread, а мои особенные трэды типа SimpleThread, в этом вся суть
// применения ThreadFactory в методе Executors.newFixedThreadPool​(int nThreads, ThreadFactory threadFactory) - задать
// количество трэдов и использовать кастомные трэды, которые поставляет написанная фабрика
class MyFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new SimpleThread(r);
//        return new Thread(r);
    }
}

class SimpleThread extends Thread {
    public SimpleThread(Runnable target) {
        super(target);
    }
}