package hashMapVShashTable.step2;

import java.util.HashMap;

public class TestCollection {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adc", "物理英雄");
        hashMap.put("apc", "魔法英雄");
        hashMap.put("t", "坦克");

        reserve(hashMap);

        System.out.println(hashMap);

    }

    public static void reserve(HashMap<String, String> hashMap) {
        HashMap<String, String> temp = new HashMap<>();
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            temp.put(value, key);
        }
        hashMap.clear();
        hashMap.putAll(temp);
    }
}
