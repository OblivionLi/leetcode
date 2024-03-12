package ds.MyHT;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyHT<K, V> {
    int size;
    int capacity;
    List<Entry<K, V>>[] table;

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        // Its own hashCode to avoid collisions
//        @Override
//        public int hashCode() {
//            int result = 31 * key.hashCode();
//            result = 31 * result + (value != null ? value.hashCode() : 0);
//
//            return result;
//        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public MyHT(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V temp = entry.getValue();
                table[index].remove(entry);
                size--;
                return temp;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        for (List<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    if (entry.getValue() != null && entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keys() {
        Set<K> keys = new HashSet<>();

        for (List<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    if (entry.getKey() != null) {
                        keys.add(entry.getKey());
                    }
                }
            }
        }

        return keys;
    }

    public List<V> values() {
        List<V> values = new LinkedList<>();

        for (List<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    if (entry.getKey() != null) {
                        values.add(entry.getValue());
                    }
                }
            }
        }

        return values;
    }

    public String displayHT() {
        if (table == null) {
            return "empty";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (List<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    stringBuilder.append(entry.getKey()).append(" (key) <-> ").append(entry.getValue()).append(" (value); ");
                }
            }
        }

        return stringBuilder.toString();
    }

    public void clear() {
        size = 0;
        table = null;
        capacity = 0;
    }
}
