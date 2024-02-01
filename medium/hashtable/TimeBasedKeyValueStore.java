package medium.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        String param_2 = obj.get("foo", 1);

        System.out.println(param_2);
    }
}

class TimeMap {
    Map<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> values = data.get(key);
        Integer floorKey = values.floorKey(timestamp);

        return (floorKey != null) ? values.get(floorKey) : "";
    }
}
