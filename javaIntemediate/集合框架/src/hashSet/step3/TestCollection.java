package hashSet.step3;

import java.util.HashSet;
import java.util.Iterator;

public class TestCollection {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            hashSet.add(i);
        }

        for (Iterator<Integer> iterator = hashSet.iterator(); iterator.hasNext();) {
            Integer i = iterator.next();
            System.out.println(i);
        }

        for (Integer i : hashSet) {
            System.out.println(i);
        }
    }
}
