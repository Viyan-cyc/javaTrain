package arrayListVSlinkedList.step4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        List<Integer> list;

        list = new ArrayList<>();
        insertLast(list, "ArrayList");

        list = new LinkedList<>();
        insertLast(list, "LinkedList");
    }

    public static void insertLast(List list, String type) {
        int total = 100000;
        int num = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            list.add(num);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最后面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
    }
}
