package hashMap.step4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {

        final String HERO_5555 = "hero-5555";

        List<Hero> hs = new ArrayList();
        for (int i = 0; i < 300000; i++) {
            hs.add(new Hero(randomName()));
        }

        // ******
        HashMap<String, List<Hero>> heroMap = new HashMap<>();
        for (Hero h : hs) {
            List<Hero> heroes = heroMap.get(h.name);
            if (heroes == null) {
                heroes = new ArrayList<>();
                heroMap.put(h.name, heroes);
            }
            heroes.add(h);
        }

        findFor(hs, HERO_5555);
        findMap(heroMap, HERO_5555);
    }

    public static void findFor(List<Hero> hs, String search) {
        // 通过for查找
        long start = System.currentTimeMillis();
        List<Hero> resultFor = new ArrayList<>();
        for (Hero h : hs) {
            if (h.name.equals(search)) {
                resultFor.add(h);
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("通过for，一共找到%d个hero，耗时%d毫秒%n", resultFor.size(), end - start);
    }

    public static void findMap(HashMap<String, List<Hero>> heroMap, String name) {
        long start = System.currentTimeMillis();
        List<Hero> resultMap = heroMap.get(name);
        long end = System.currentTimeMillis();
        System.out.printf("通过for，一共找到%d个hero，耗时%d毫秒%n", resultMap.size(), end - start);
    }

    public static String randomName() {
        int num =  (int) (Math.random() * 9000 + 1000);
        return "hero-" + num;
    }
}
