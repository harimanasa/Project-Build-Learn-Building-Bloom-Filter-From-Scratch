import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter {
    private final BitSet bitSet;
    private final int size;
    private final Function<String, Integer>[] hashFunctions;

    @SafeVarargs
    public BloomFilter(int size, Function<String, Integer>... hashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }

    public void add(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.apply(item) % size);
            bitSet.set(index);
        }
    }

    public boolean contains(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction.apply(item) % size);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Define hash functions
        Function<String, Integer> hashFn1 = createHashFunction("MD5");
        Function<String, Integer> hashFn2 = createHashFunction("SHA-1");
        Function<String, Integer> hashFn3 = createHashFunction("SHA-256");

        // Create a Bloom filter with 1000 bits and 3 hash functions
        BloomFilter bloomFilter = new BloomFilter(1000, hashFn1, hashFn2, hashFn3);

        // Add items to the Bloom filter
        bloomFilter.add("apple");
        bloomFilter.add("banana");

        // Check membership
        System.out.println(bloomFilter.contains("apple"));  // True
        System.out.println(bloomFilter.contains("banana")); // True
        System.out.println(bloomFilter.contains("cherry")); // False
    }

    private static Function<String, Integer> createHashFunction(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        return (String input) -> {
            messageDigest.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            int hash = 0;
            for (byte b : digest) {
                hash = (hash << 8) | (b & 0xFF);
            }
            return hash;
        };
    }
}