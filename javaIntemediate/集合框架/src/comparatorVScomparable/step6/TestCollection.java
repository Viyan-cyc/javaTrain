package comparatorVScomparable.step6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestCollection {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item("item" + i, new Random().nextInt(100)));
        }

        Collections.sort(itemList);
        System.out.println(itemList);
    }
}
