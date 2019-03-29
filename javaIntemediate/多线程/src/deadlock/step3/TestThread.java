package deadlock.step3;

import synchronizedTest.step1.Hero;

public class TestThread {
    public static void main(String[] args) {
        Hero a = new Hero();
        a.name = "a";

        Hero b = new Hero();
        b.name = "b";

        Hero c = new Hero();
        c.name = "c";

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("t1占用a，等待b");
                    synchronized (b) {
                        System.out.println("t1占用b");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("t2占用b，等待a");
                    synchronized (a) {
                        System.out.println("t2占用a");
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                synchronized (c) {
                    System.out.println("t3占用c，等待b");
                    synchronized (b) {
                        System.out.println("t3占用b");
                    }
                }
            }
        };
        t3.start();
    }


}
