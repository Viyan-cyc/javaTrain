package comparatorVScomparable.step2;


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

        Collections.sort(heroList);
        System.out.println("血量排序");
        System.out.println(heroList);
    }
}
