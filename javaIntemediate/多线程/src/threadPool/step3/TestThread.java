package threadPool.step3;

import threadPool.step2.ThreadPool;

public class TestThread {
    public static void main(String[] args) {
        int sleep = 1000;

        ThreadPool threadPool = new ThreadPool();
        while (true) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("执行花1s");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.add(task);
            try {
                sleep = sleep > 100 ? sleep - 100 : sleep;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
