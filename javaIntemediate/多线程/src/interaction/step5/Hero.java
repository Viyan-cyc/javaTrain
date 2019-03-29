package interaction.step5;

public class Hero {
    public String name;
    public float hp;

    public int damage;

    public synchronized void recover() {
        if (hp >= 1000) {
            try {
                System.out.println("血回满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知在等待this对象的线程醒过来
        this.notify();
    }

    public synchronized void hurt() {
        if (hp <= 1) {
            try {
                System.out.println("血量最低了");
                // 让占用this的实例暂时释放对this的占用，并等待
                // 这样加血线程就有机会进入recover()加血方法
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp -= 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    public void attackHero(Hero h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "死了！");
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
}

