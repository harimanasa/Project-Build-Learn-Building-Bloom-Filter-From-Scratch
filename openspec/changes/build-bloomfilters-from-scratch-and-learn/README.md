# Bloom Filter Project

## Overview
This project implements a Bloom filter, a probabilistic data structure used for efficient membership testing. The implementation is provided in both Python and Java, along with a comprehensive guide explaining the concept, usage, and design of Bloom filters.

---

## Features
- **Bloom Filter Implementation**:
  - Python and Java implementations.
  - Methods for adding elements and checking membership.
- **Comprehensive Guide**:
  - Explains the theory behind Bloom filters.
  - Includes formulas, examples, and best practices.
- **Customizable Hash Functions**:
  - Support for cryptographic and non-cryptographic hash functions.

---

## File Structure
```
.
├── BloomFilter.py          # Python implementation of the Bloom filter
├── BloomFilter.java        # Java implementation of the Bloom filter
├── BloomFilterGuide.md     # Comprehensive guide to Bloom filters
├── README.md               # Project overview (this file)
```

---

## Getting Started

### Prerequisites
- **Python**: Version 3.6 or higher.
- **Java**: JDK 8 or higher.

### Running the Python Implementation
1. Navigate to the project directory.
2. Run the Python script:
   ```bash
   python BloomFilter.py
   ```

### Running the Java Implementation
1. Compile the Java file:
   ```bash
   javac BloomFilter.java
   ```
2. Run the compiled Java program:
   ```bash
   java BloomFilter
   ```

---

## Usage
### Python Example
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

### Java Example
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

## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests to improve the project.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

---

## Acknowledgments
- Inspired by the need to understand and implement Bloom filters from scratch.
- Special thanks to the creators of cryptographic and non-cryptographic hash functions used in this project.