package threadPool.step2;

public class TestThread {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务被执行");
                }
            };

            threadPool.add(task);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
