package lock.step9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    public static void main(String[] args) {

        Lock ssLock = new ReentrantLock();
        Lock ttLock = new ReentrantLock();

        Thread t1 = new Thread() {
            boolean ssLocked = false;
            boolean ttLocked = false;
            @Override
            public void run() {
                try {
                    ssLocked = ssLock.tryLock(10, TimeUnit.SECONDS);
                    if (ssLocked) {
                        System.out.println("t1成功占用ss");
                        Thread.sleep(1000);
                        System.out.println("t1试图占用tt");
                        try {
                            ttLocked = ttLock.tryLock(10, TimeUnit.SECONDS);
                            if (ttLocked) {
                                System.out.println("t1成功占用tt");
                            } else {
                                System.out.println("t1老占用不到tt，放弃");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            if (ttLocked) {
                                System.out.println("t1释放tt");
                                ttLock.unlock();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (ssLocked) {
                        System.out.println("t1释放ss");
                        ssLock.unlock();
                    }
                }
            }
        };
        t1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            boolean ttLocked = false;
            boolean ssLocked = false;
            @Override
            public void run() {
                try {
                    ttLocked = ttLock.tryLock(10,TimeUnit.SECONDS);
                    if (ttLocked) {
                        System.out.println("t2占用了tt");
                        Thread.sleep(1000);
                        System.out.println("t2试图占用ss");
                        try {
                            ssLocked = ssLock.tryLock(10,TimeUnit.SECONDS);
                            if (ssLocked) {
                                System.out.println("t2占用了ss");
                            } else {
                                System.out.println("t2老占用不到ss，放弃");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            if (ssLocked) {
                                System.out.println("t2释放ss");
                                ssLock.unlock();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (ttLocked) {
                        System.out.println("t2释放tt");
                        ttLock.unlock();
                    }
                }
            }
        };
        t2.start();
    }
}
