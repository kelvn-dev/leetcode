package systemdesign;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        /**
         * loadFactor (default 0.75f) is how full the hash table can get before its capacity is automatically increased
         * accessOrder true to maintain order of last access, default false to maintain insert order
         */
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);

        cache.put("A", "Apple");
        cache.put("B", "Banana");
        cache.put("C", "Cat");

        cache.get("A"); // A becomes most recently used
        cache.put("D", "Dog"); // B gets evicted
    }
}
