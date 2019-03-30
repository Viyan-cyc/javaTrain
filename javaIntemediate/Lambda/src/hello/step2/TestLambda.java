package hello.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");

        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public boolean test(Hero hero) {
                return  (hero.hp > 100 && hero.damage < 50);
            }
        };
        filter(heros, heroChecker);
    }

    public static void filter(List<Hero> heroes, HeroChecker heroChecker) {
        for (Hero hero : heroes) {
            if (heroChecker.test(hero)) {
                System.out.println(hero);
            }
        }
    }


}
