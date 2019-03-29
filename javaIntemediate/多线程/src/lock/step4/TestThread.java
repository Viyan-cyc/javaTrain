package lock.step4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    log("线程t1启动");
                    log("t1试图占用对象lock");

                    lock.lock();

                    log("t1占有对象：lock");
                    log("t1进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("t1临时释放对象 lock， 并等待");
                    condition.await();
                    log("t1重新占有对象 lock，并进行5秒的业务操作");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("t1释放对象：lock");
                    lock.unlock();
                }
                log("t1线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            //先让t1飞2秒
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Thread t2 = new Thread() {

            public void run() {
                try {
                    log("线程t2启动");
                    log("t2试图占有对象：lock");

                    lock.lock();

                    log("t2占有对象：lock");
                    log("t2进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("t2唤醒等待中的线程");
                    condition.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("t2释放对象：lock");
                    lock.unlock();
                }
                log("t2线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }
}
