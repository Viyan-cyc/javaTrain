package comparatorVScomparable.step6;

import java.util.Iterator;

public class Item implements Comparable<Item>{
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]\r\n";
    }

    @Override
    public int compareTo(Item o) {
        return o.price - this.price;
    }
}
