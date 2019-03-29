package deadlock.step1;

import synchronizedTest.step1.Hero;

public class TestThread {

    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "九尾狐妖";
        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (ahri) {
                    System.out.println("t1占用了九尾狐妖");
                    try {
                        // 让t2有充足时间占用安妮
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占用安妮");
                    System.out.println("t1等待中。。。");
                    synchronized (annie) {
                        System.out.println("t1占用了安妮");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (annie) {
                    System.out.println("t2占用了安妮");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占用九尾狐妖");
                    System.out.println("t2等待。。。");
                    synchronized (ahri) {
                        System.out.println("t2占用了九尾狐妖");
                    }
                }
            }
        };
        t2.start();
    }
}
