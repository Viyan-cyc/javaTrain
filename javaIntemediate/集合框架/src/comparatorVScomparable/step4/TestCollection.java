package comparatorVScomparable.step4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class TestCollection {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 <= o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(integerComparator);

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            treeSet.add(random.nextInt(100));
        }

        System.out.println(treeSet);
    }
}
