package comparatorVScomparable.step1;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            heroList.add(new Hero("hero" + i, random.nextInt(100), random.nextInt(100)));
        }

        System.out.println("初始化后的集合");
        System.out.println(heroList);

        Comparator<Hero> heroComparator = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.hp >= o2.hp) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(heroList, heroComparator);
        System.out.println("血量排序");
        System.out.println(heroList);
    }
}
