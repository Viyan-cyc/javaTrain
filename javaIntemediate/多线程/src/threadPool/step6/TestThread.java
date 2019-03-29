package threadPool.step6;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    static String search = "test";

    public static void search(File file) {
        if (file.isFile()) {
            if (file.getName().endsWith(".txt")) {
                threadPoolExecutor.execute(new SearchFileThread(file, search));
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                search(f);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:/workcode/java/train/java/TestFolder");
        TestThread.search(file);
    }
}
