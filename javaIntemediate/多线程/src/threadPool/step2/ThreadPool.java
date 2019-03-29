package threadPool.step2;

import java.util.LinkedList;

public class ThreadPool {
    // 线程池大小
    int threadPoolSize;

    /**
     * 任务容器
     */
    LinkedList<Runnable> tasks = new LinkedList<>();

    // 试图消费任务的线程
    // 启动10个任务消费者线程
    public ThreadPool() {
        threadPoolSize = 10;
        for (int i = 0; i < threadPoolSize; i++) {
            synchronized (tasks) {
                new TaskConsumeThread("任务消费者线程" + i).start();
            }
        }
    }

    // 往任务容器添加任务
    public void add(Runnable task) {
        synchronized (tasks) {
            System.out.println("添加任务");
            tasks.push(task);
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {
        // 给线程命名
        public TaskConsumeThread(String name) {
            super(name);
        }

        Runnable task;

        @Override
        public void run() {
            System.out.println("启动：" + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "获取到任务，并执行");
                task.run();
            }
        }
    }
}
