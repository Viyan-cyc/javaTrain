package interaction.step2;

public class TestThread {

    public static void main(String[] args) {
        final Hero hero = new Hero();
        hero.name = "hero";
        hero.hp = 10;

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    hero.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    hero.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }



}
