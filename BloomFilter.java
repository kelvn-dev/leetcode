import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter {
    private final BitSet bitArray;
    private final int size;
    private final Function<String, Integer>[] hashFunctions;

    public BloomFilter(int size, Function<String, Integer>... hashFunctions) {
        this.size = size;
        this.bitArray = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }

    // Method to add an element to the Bloom Filter
    public void add(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.apply(item) % size);
            bitArray.set(index);
        }
    }

    // Method to check if an element is possibly in the Bloom Filter
    public boolean mightContain(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.apply(item) % size);
            if (!bitArray.get(index)) {
                return false; // If any bit is 0, the item is definitely not in the set
            }
        }
        return true; // All bits are 1, so the item is probably in the set
    }
}