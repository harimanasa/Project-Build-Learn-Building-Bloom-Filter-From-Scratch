# Bloom Filter: A Complete Guide

## Introduction
A Bloom filter is a probabilistic data structure used to test whether an element is a member of a set. It is highly space-efficient and allows for quick membership checks, but it may produce false positives. This guide will walk you through the concept, implementation, and usage of a Bloom filter, step by step.

---

## What is a Bloom Filter?
A Bloom filter is a bit array of fixed size, initially set to all zeros. It uses multiple hash functions to map elements to positions in the bit array. When an element is added, the corresponding bits are set to 1. To check if an element is in the set, the same hash functions are applied, and the corresponding bits are checked. If all the bits are set to 1, the element is probably in the set; otherwise, it is definitely not.

### Key Characteristics
- **Space-efficient**: Uses less memory compared to other data structures.
- **Probabilistic**: May produce false positives but never false negatives.
- **No deletions**: Once an element is added, it cannot be removed.

---

## How Does It Work?
### Adding an Element
1. Apply multiple hash functions to the element.
2. Map the hash values to positions in the bit array.
3. Set the corresponding bits to 1.

### Checking Membership
1. Apply the same hash functions to the element.
2. Check the corresponding bits in the bit array.
3. If all bits are 1, the element is probably in the set; if any bit is 0, it is definitely not.

### False Positives
A Bloom filter may return a false positive, meaning it indicates that an element is in the set when it is not. This happens due to hash collisions, where multiple elements map to the same bits.

---

## Implementation
### Python Implementation
Here is a Python implementation of a Bloom filter:
```python
class BloomFilter:
    def __init__(self, size, hash_functions):
        self.size = size
        self.bit_array = [0] * size
        self.hash_functions = hash_functions

    def add(self, item):
        for hash_function in self.hash_functions:
            index = hash_function(item) % self.size
            self.bit_array[index] = 1

    def contains(self, item):
        for hash_function in self.hash_functions:
            index = hash_function(item) % self.size
            if self.bit_array[index] == 0:
                return False
        return True
```

### Java Implementation
Here is a Java implementation of a Bloom filter:
```java
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
}
```

---

## Use Cases
### Applications
- **Databases**: To check if a key exists before performing a lookup.
- **Caching**: To avoid fetching non-existent data.
- **Distributed Systems**: To reduce communication overhead.

### Example Usage
#### Python
```python
import hashlib

def hash_fn1(x):
    return int(hashlib.md5(x.encode()).hexdigest(), 16)

def hash_fn2(x):
    return int(hashlib.sha1(x.encode()).hexdigest(), 16)

def hash_fn3(x):
    return int(hashlib.sha256(x.encode()).hexdigest(), 16)

bloom_filter = BloomFilter(1000, [hash_fn1, hash_fn2, hash_fn3])
bloom_filter.add("apple")
print(bloom_filter.contains("apple"))  # True
print(bloom_filter.contains("banana")) # False
```

#### Java
```java
Function<String, Integer> hashFn1 = createHashFunction("MD5");
Function<String, Integer> hashFn2 = createHashFunction("SHA-1");
Function<String, Integer> hashFn3 = createHashFunction("SHA-256");

BloomFilter bloomFilter = new BloomFilter(1000, hashFn1, hashFn2, hashFn3);
bloomFilter.add("apple");
System.out.println(bloomFilter.contains("apple"));  // True
System.out.println(bloomFilter.contains("banana")); // False
```

---

## Advantages and Limitations
### Advantages
- Space-efficient.
- Fast membership checks.

### Limitations
- False positives.
- Cannot delete elements.
- Fixed size.

---

## Conclusion
Bloom filters are powerful tools for efficient membership testing in scenarios where space and speed are critical. While they have limitations, their advantages make them invaluable in many applications. By understanding and implementing Bloom filters, you can leverage their strengths in your projects.